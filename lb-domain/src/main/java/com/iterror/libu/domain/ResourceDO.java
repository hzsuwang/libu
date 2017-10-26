package com.iterror.libu.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import com.iterror.libu.common.dao.domain.BaseDO;

import lombok.Data;

/**
 * Created by tony.yan on 2017/10/26.
 */
@Data
@Table("lb_resource")
@Comment("资源信息表")
public class ResourceDO extends BaseDO {

    @Column("name")
    @Comment("名称")
    private String            name;                                   // 名称

    @Column("code")
    @Comment("编码")
    private String            code;                                   // 编码

    @Column("content")
    @Comment("内容")
    private String            content;                                // 内容
}
