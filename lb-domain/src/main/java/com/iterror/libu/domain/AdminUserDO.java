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
@Comment("后台用户信息表")
public class AdminUserDO extends BaseDO {

    @Column("user_name")
    @Comment("用户名")
    private String userName;

    @Column("password")
    @Comment("密码")
    private String password;

    @Column("user_mark")
    @Comment("备注")
    private String userMark;

    @Column("status")
    @Comment("状态")
    private int    status;
}
