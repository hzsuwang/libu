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
@Comment("用户表")
public class ContactGroupDO extends BaseDO {

    @Column("name")
    @Comment("分组名称")
    private String name;    // 分组名称

    @Column("group_bak")
    @Comment("分组备注")
    private String groupBak;// 分组备注
}
