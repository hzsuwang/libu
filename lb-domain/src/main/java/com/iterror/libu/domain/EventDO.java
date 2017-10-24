package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */

/**
 * 事件
 */
@Data
@Table("lb_event")
@Comment("用户表")
public class EventDO extends BaseDO {

    @Column("title")
    @Comment("事件标题")
    private String title;    // 事件标题

    @Column("event_desc")
    @Comment("事件描述")
    private String eventDesc;// 事件描述

    @Column("event_time")
    @Comment("事件时间")
    private Date   eventTime;// 事件时间

    @Column("icon")
    @Comment("图标地扯")
    private String icon;     // 图标地扯
}
