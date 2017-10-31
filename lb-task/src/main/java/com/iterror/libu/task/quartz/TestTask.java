package com.iterror.libu.task.quartz;

import com.iterror.libu.common.task.BaseTask;

/**
 * Created by tony.yan on 2017/10/31.
 */
public class TestTask extends BaseTask {

    @Override
    public void work() {
        if (logger.isInfoEnabled()) {
            logger.info("测试任务线程开始执行");
        }
    }
}
