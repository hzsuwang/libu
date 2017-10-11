package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */

/**
 * 事件
 */
@Data
public class EventDO extends BaseDO {

    private String title;    // 事件标题
    private String eventDesc;// 事件描述
    private Date   eventTime;// 事件时间
}
