package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;

/**
 * Created by tony.yan on 2017/10/11.
 */
public class EventFlowDO extends BaseDO {

    private long   eventId;  // 事件id
    private long   contactId;// 联系人id
    private int    money;    // 分
    private String flowBak;  // 备注
}
