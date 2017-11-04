package com.iterror.libu.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import com.iterror.libu.common.dao.domain.BaseDO;

import lombok.Data;

/**
 * Created by tony.yan on 2017/11/1.
 */
@Data
@Table("lb_admin_user")
@Comment("充值记录表")
public class AdminUserDO extends BaseDO {

    @Column("user_name")
    @Comment("产品的价格")
    private String userName;

    @Column("password")
    @Comment("产品的价格")
    private String password;

    @Column("user_mark")
    @Comment("产品的价格")
    private String userMark;

    @Column("status")
    @Comment("产品的价格")
    private int    status;
}
