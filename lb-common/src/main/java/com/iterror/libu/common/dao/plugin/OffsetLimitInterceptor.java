package com.iterror.libu.common.dao.plugin;

/**
 * Created by tony.yan on 2017/10/12.
 */

import com.iterror.libu.common.dao.dialect.Dialect;
import com.iterror.libu.common.util.PropertiesHelper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
public class OffsetLimitInterceptor implements Interceptor {
    private static final int MAPPED_STATEMENT_INDEX = 0;
    private static final int PARAMETER_INDEX = 1;
    private static final int ROWBOUNDS_INDEX = 2;
    private Dialect dialect;

    public OffsetLimitInterceptor() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        this.processIntercept(invocation.getArgs());
        return invocation.proceed();
    }

    void processIntercept(Object[] queryArgs) {
        MappedStatement ms = (MappedStatement)queryArgs[0];
        Object parameter = queryArgs[1];
        RowBounds rowBounds = (RowBounds)queryArgs[2];
        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();
        if(this.dialect.supportsLimit() && (offset != 0 || limit != 2147483647)) {
            BoundSql boundSql = ms.getBoundSql(parameter);
            String sql = boundSql.getSql().trim();
            if(this.dialect.supportsLimitOffset()) {
                sql = this.dialect.getLimitString(sql, offset, limit);
                offset = 0;
            } else {
                sql = this.dialect.getLimitString(sql, 0, offset + limit);
            }

            limit = 2147483647;
            queryArgs[2] = new RowBounds(offset, limit);
            BoundSql newBoundSql = this.copyFromBoundSql(ms, sql, boundSql);
            MappedStatement newMs = this.copyFromMappedStatement(ms, new OffsetLimitInterceptor.BoundSqlSqlSource(newBoundSql));
            queryArgs[0] = newMs;
        }

    }

    private BoundSql copyFromBoundSql(MappedStatement ms, String sql, BoundSql boundSql) {
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if(parameterMappings != null && !parameterMappings.isEmpty()) {
            Iterator var6 = parameterMappings.iterator();

            while(var6.hasNext()) {
                ParameterMapping mapping = (ParameterMapping)var6.next();
                String prop = mapping.getProperty();
                if(boundSql.hasAdditionalParameter(prop)) {
                    newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
                }
            }
        }

        return newBoundSql;
    }

    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        builder.keyProperty(this.getKeyProperty(ms.getKeyProperties()));
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        String dialectClass = (new PropertiesHelper(properties)).getRequiredString("dialectClass");

        try {
            this.dialect = (Dialect)Class.forName(dialectClass).newInstance();
        } catch (Exception var4) {
            throw new RuntimeException("cannot create dialect instance by dialectClass:" + dialectClass, var4);
        }

        System.out.println(OffsetLimitInterceptor.class.getSimpleName() + ".dialect=" + dialectClass);
    }

    private String getKeyProperty(String[] keyProperties) {
        StringBuilder builder = new StringBuilder();
        if(keyProperties != null && keyProperties.length > 0) {
            int length = keyProperties.length;

            for(int i = 0; i < length; ++i) {
                builder.append(keyProperties[i]);
                if(i < length - 1) {
                    builder.append(",");
                }
            }

            return builder.toString();
        } else {
            return null;
        }
    }

    public static class BoundSqlSqlSource implements SqlSource {
        private BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return this.boundSql;
        }
    }
}
