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
@Table("lb_contact_group")
@Comment("联系人分组信息表")
public class ContactGroupDO extends BaseDO {

    @Column("user_id")
    @Comment("用户id")
    private Long userId;      // 用户id

    @Column("name")
    @Comment("分组名称")
    private String name;    // 分组名称

    @Column("group_bak")
    @Comment("分组备注")
    private String groupBak;// 分组备注
}
