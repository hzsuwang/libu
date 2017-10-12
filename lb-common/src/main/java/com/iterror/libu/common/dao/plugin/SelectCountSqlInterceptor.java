package com.iterror.libu.common.dao.plugin;

/**
 * Created by tony.yan on 2017/10/12.
 */

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
public class SelectCountSqlInterceptor implements Interceptor {
    public static final String COUNT = "_count";
    private static final int MAPPED_STATEMENT_INDEX = 0;
    private static final int PARAMETER_INDEX = 1;

    public SelectCountSqlInterceptor() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        this.processCountSql(invocation.getArgs());
        return invocation.proceed();
    }

    private void processCountSql(Object[] queryArgs) {
        if(queryArgs[1] instanceof Map) {
            Map parameter = (Map)queryArgs[1];
            if(parameter.containsKey("_count")) {
                MappedStatement ms = (MappedStatement)queryArgs[0];
                BoundSql boundSql = ms.getBoundSql(parameter);
                String sql = ms.getBoundSql(parameter).getSql().trim();
                BoundSql newBoundSql = this.copyFromBoundSql(ms, getCountSQL(sql), boundSql);
                MappedStatement newMs = this.copyFromMappedStatement(ms, new OffsetLimitInterceptor.BoundSqlSqlSource(newBoundSql));
                queryArgs[0] = newMs;
            }
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
        builder.keyProperty(getKeyProperty(ms.getKeyProperties()));
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        List<ResultMap> resultMaps = new ArrayList();
        String id = "-inline";
        if(ms.getResultMaps() != null) {
            id = ((ResultMap)ms.getResultMaps().get(0)).getId() + "-inline";
        }

        ResultMap resultMap = (new org.apache.ibatis.mapping.ResultMap.Builder((Configuration)null, id, Long.class, new ArrayList())).build();
        resultMaps.add(resultMap);
        builder.resultMaps(resultMaps);
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    private static String getKeyProperty(String[] keyProperties) {
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

    private static String getCountSQL(String sql) {
        String lowerCaseSQL = sql.toLowerCase().replace("\n", " ").replace("\t", " ");
        int index = lowerCaseSQL.indexOf(" order ");
        if(index != -1) {
            sql = sql.substring(0, index);
        }

        return lowerCaseSQL.indexOf(" group ") != -1?"SELECT COUNT(*) FROM (SELECT COUNT(*) AS COUNT_" + sql.substring(lowerCaseSQL.indexOf(" from ")) + ") TABLE_":"SELECT COUNT(*) AS COUNT_" + sql.substring(lowerCaseSQL.indexOf(" from "));
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }
}
