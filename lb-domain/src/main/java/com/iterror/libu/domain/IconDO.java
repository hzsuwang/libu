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
@Table("lb_icon")
@Comment("用户表")
public class IconDO extends BaseDO {

    @Column("icon_url")
    @Comment("图标地扯")
    private String iconUrl;// 图标地扯
}
