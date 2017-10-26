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
@Table("lb_contact")
@Comment("联系人信息表")
public class ContactDO extends BaseDO {

    @Column("user_id")
    @Comment("用户id")
    private Long userId;      // 用户id

    @Column("name")
    @Comment("联系人名称")
    private String name;      //联系人名称

    @Column("phone")
    @Comment("联系人电话")
    private String phone;

    @Column("phone1")
    @Comment("联系人电话1")
    private String phone1;

    @Column("phone2")
    @Comment("联系人电话2")
    private String phone2;

    @Column("contact_bak")
    @Comment("联系人备注")
    private String contactBak;//联系人备注

    @Column("group_id")
    @Comment("联系人分组")
    private long   groupId;   //联系人分组
}
