package com.iterror.libu.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import com.iterror.libu.common.dao.domain.BaseDO;

import lombok.Data;

/**
 * Created by tony.yan on 2017/10/24.
 */
@Data
@Table("lb_member")
@Comment("用户表")
public class MemberFlowDO extends BaseDO{

    @Column("user_id")
    @Comment("用户id")
    private long userId;

    @Column("pid")
    @Comment("产品id")
    private long pid;

    @Column("times")
    @Comment("时长")
    private int times;
}
