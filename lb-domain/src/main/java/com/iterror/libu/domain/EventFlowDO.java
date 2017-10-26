package com.iterror.libu.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import com.iterror.libu.common.dao.domain.BaseDO;

import lombok.Data;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
@Table("lb_event_flow")
@Comment("事件记录表")
public class EventFlowDO extends BaseDO {

    @Column("user_id")
    @Comment("用户id")
    private Long userId;      // 用户id

    @Column("event_id")
    @Comment("事件id")
    private long   eventId;  // 事件id

    @Column("contact_id")
    @Comment("联系人id")
    private long   contactId;// 联系人id

    @Column("money")
    @Comment("分")
    private int    money;    // 分

    @Column("flow_bak")
    @Comment("备注")
    private String flowBak;  // 备注
}
