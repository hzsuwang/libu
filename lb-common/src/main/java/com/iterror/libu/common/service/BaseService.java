package com.iterror.libu.common.service;

import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tony.yan on 2017/10/11.
 */
public class BaseService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected Dao dao;
}
