package com.iterror.libu.common.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tony.yan on 2017/10/30.
 */
public abstract class BaseTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract void work();
}
