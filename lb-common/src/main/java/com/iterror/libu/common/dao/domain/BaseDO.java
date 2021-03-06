package com.iterror.libu.common.dao.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;

import lombok.Data;
import org.nutz.dao.entity.annotation.Id;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class BaseDO implements java.io.Serializable{

    @Id
    @Comment("序号")
    private Long id;

    @Column("deleted")
    @Comment("删除标记")
    private Integer deleted;

    @Column("create_time")
    @Comment("创建时间")
    private Date createTime;

    @Column("edit_time")
    @Comment("修改时间")
    private Date editTime;
}
