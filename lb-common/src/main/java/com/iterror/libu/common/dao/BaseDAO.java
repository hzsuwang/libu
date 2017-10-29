package com.iterror.libu.common.dao;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Configuration
@Component("dao")
public class BaseDAO extends NutDao implements Dao {

    private DataSource druidDataSource;

    public void setDruidDataSource(DataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
        setDataSource(druidDataSource);
    }
}
