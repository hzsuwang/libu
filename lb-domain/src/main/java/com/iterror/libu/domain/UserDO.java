package com.iterror.libu.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import com.iterror.libu.common.dao.domain.BaseDO;

import lombok.Data;

/**
 * Created by tony.yan on 2017/10/10.
 */
@Data
@Table("lb_user")
@Comment("用户表")
public class UserDO extends BaseDO {

    @Column("phone")
    @Comment("手机号")
    private String  phone;     // 手机号

    @Column("password")
    @Comment("密码")
    private String  password;  // 密码

    @Column("gender")
    @Comment("性别")
    private Integer gender;    // 性别

    @Column("status")
    @Comment("状态 1：正常用户 0：无效用户")
    private Integer status;    // 状态 1：正常用户 0：无效用户

    @Column("oauth_from")
    @Comment("0手机登录 1微信登录")
    private Integer oauthFrom; // 0手机登录 1微信登录
}
