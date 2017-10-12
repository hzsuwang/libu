package com.iterror.libu.common.dao;


import com.iterror.libu.common.dao.exception.DatabaseException;
import com.iterror.libu.common.dao.mapper.MapMapper;
import com.iterror.libu.common.dao.page.Page;
import com.iterror.libu.common.dao.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by tony.yan on 2017/10/12.
 */
public class MyBatisDAO extends SqlSessionDaoSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger("SQL_LOGGER");

    public MyBatisDAO() {
    }

    public int insert(final String sqlMapId, final Object object) {
        return ((Integer)this.execute(new MyBatisDAO.SqlSessionCallback<Integer>() {
            public Integer doInSession(SqlSession session) {
                try {
                    return Integer.valueOf(session.insert(sqlMapId, object));
                } catch (Exception var3) {
                    MyBatisDAO.LOGGER.error("SQL执行出错: " + sqlMapId, var3);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, var3);
                }
            }
        })).intValue();
    }

    public <T> List<T> findForList(String sqlMapId) {
        return this.findForList(sqlMapId, (Object)null);
    }

    public <T> List<T> findForList(final String sqlMapId, final Object param) {
        return (List)this.execute(new MyBatisDAO.SqlSessionCallback<List<T>>() {
            public List<T> doInSession(SqlSession session) {
                try {
                    return param != null?session.selectList(sqlMapId, param):session.selectList(sqlMapId);
                } catch (Exception var3) {
                    MyBatisDAO.LOGGER.error("SQL执行出错: " + sqlMapId, var3);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, var3);
                }
            }
        });
    }

    public <T> List<T> findForList(final String sqlMapId, final Object param, final int offset, final int limit) {
        return (List)this.execute(new MyBatisDAO.SqlSessionCallback<List<T>>() {
            public List<T> doInSession(SqlSession session) {
                try {
                    return session.selectList(sqlMapId, param, new RowBounds(offset, limit));
                } catch (Exception var3) {
                    MyBatisDAO.LOGGER.error("SQL执行出错: " + sqlMapId, var3);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, var3);
                }
            }
        });
    }

    public <E, K, V> Map<K, V> findForMap(String sqlMapId, MapMapper<E, K, V> mapMapper) {
        return this.findForMap(sqlMapId, (Object)null, mapMapper);
    }

    public <E, K, V> Map<K, V> findForMap(String sqlMapId, Object parameter, MapMapper<E, K, V> mapMapper) {
        List list;
        if(parameter == null) {
            list = this.findForList(sqlMapId);
        } else {
            list = this.findForList(sqlMapId, parameter);
        }

        Map<K, V> result = new HashMap();
        int i = 0;

        for(int size = list.size(); i < size; ++i) {
            int rowNum = i + 1;
            E item = (E) list.get(i);
            result.put(mapMapper.mapKey(item, rowNum), mapMapper.mapValue(item, rowNum));
        }

        return result;
    }

    public <T> Page<T> findForPage(String sqlMapId, PageRequest pageRequest) {
        Map<String, Object> params = new HashMap(pageRequest.getFilters());
        Number totalCount = null;
        if(Integer.MAX_VALUE > pageRequest.getPageSize()) {
            params.put("_count", (Object)null);
            totalCount = (Number)this.findForObject(sqlMapId, params);
            if(totalCount == null || totalCount.intValue() <= 0) {
                return new Page(pageRequest, 0);
            }

            if(totalCount.intValue() <= (pageRequest.getPageNumber() - 1) * pageRequest.getPageSize()) {
                return new Page(pageRequest.getPageSize(), pageRequest.getPageNumber(), totalCount.intValue(), new ArrayList(0));
            }

            params.remove("_count");
        }

        Map<String, Object> filters = new HashMap();
        filters.putAll(pageRequest.getFilters());
        if(totalCount == null) {
            List<T> list = this.findForList(sqlMapId, filters);
            Page<T> page = new Page(pageRequest, list.size());
            page.setResult(list);
            return page;
        } else {
            Page<T> page = new Page(pageRequest, totalCount.intValue());
            List<T> list = this.findForList(sqlMapId, filters, page.getFirstResult(), page.getPageSize());
            page.setResult(list);
            return page;
        }
    }

    public <T> T findForObject(String sqlMapId) {
        return this.findForObject(sqlMapId, (Object)null);
    }

    public <T> T findForObject(final String sqlMapId, final Object param) {
        return this.execute(new MyBatisDAO.SqlSessionCallback<T>() {
            public T doInSession(SqlSession session) {
                try {
                    return param != null?session.selectOne(sqlMapId, param):session.selectOne(sqlMapId);
                } catch (Exception var3) {
                    MyBatisDAO.LOGGER.error("SQL执行出错: " + sqlMapId, var3);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, var3);
                }
            }
        });
    }

    public int update(final String sqlMapId, final Object param) {
        return ((Integer)this.execute(new MyBatisDAO.SqlSessionCallback<Integer>() {
            public Integer doInSession(SqlSession session) {
                try {
                    return Integer.valueOf(session.update(sqlMapId, param));
                } catch (Exception var3) {
                    MyBatisDAO.LOGGER.error("SQL执行出错: " + sqlMapId, var3);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, var3);
                }
            }
        })).intValue();
    }

    public int delete(String sqlMapId) {
        return this.delete(sqlMapId, (Object)null);
    }

    public int delete(final String sqlMapId, final Object param) {
        return ((Integer)this.execute(new MyBatisDAO.SqlSessionCallback<Integer>() {
            public Integer doInSession(SqlSession session) {
                return param != null?Integer.valueOf(session.delete(sqlMapId, param)):Integer.valueOf(session.delete(sqlMapId));
            }
        })).intValue();
    }

    public <T> T execute(MyBatisDAO.SqlSessionCallback<T> action) {
        try {
            return action.doInSession(this.getSqlSession());
        } catch (Exception var3) {
            LOGGER.error("Fail to getSqlSession", var3);
            throw new DatabaseException("Fail to getSqlSession", var3);
        }
    }

    public interface SqlSessionCallback<T> {
        T doInSession(SqlSession var1);
    }
}
