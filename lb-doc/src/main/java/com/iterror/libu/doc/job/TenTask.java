package com.iterror.libu.doc.job;

import com.iterror.libu.common.task.BaseTask;
import com.iterror.libu.doc.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 10分钟的时间job
 * Created by tony.yan on 2017/10/30.
 */
public class TenTask extends BaseTask {

    @Autowired
    private ResourceService resourceService;

    @Override
    public void work() {
        logger.info("TenTask start......");
        resourceService.clearCashData();
        logger.info("TenTask end........");
    }
}
