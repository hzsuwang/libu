package com.iterror.libu.doc.job;

import com.iterror.libu.common.task.BaseTask;

/**
 * 30分钟的时间job
 * Created by tony.yan on 2017/10/31.
 */
public class ThirtyTask extends BaseTask{
    @Override
    public void work() {
        logger.info("ThirtyTask start......");
        logger.info("ThirtyTask end........");
    }
}
