package com.iterror.libu.doc.quartz;

import com.iterror.libu.common.task.BaseTask;

/**
 * 5分钟的时间job
 * Created by tony.yan on 2017/10/31.
 */
public class FiveTask extends BaseTask {

    @Override
    public void work() {
        logger.info("TenTaskFiveTask start......");
        logger.info("TenTask end........");
    }
}
