package com.iterror.libu.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import com.iterror.libu.common.dao.domain.BaseDO;

/**
 * Created by tony.yan on 2017/10/24.
 */
@Table("lb_sequence")
@Comment("序列信息表")
public class SequenceDO extends BaseDO{

    @Column("seq_name")
    @Comment("名称")
    private String            seqName;                                // 名称

    @Column("seq_cache_value")
    @Comment("缓存的id池")
    private int               seqCacheValue;                          // 缓存的id池

    @Column("seq_value")
    @Comment("当前最大id")
    private long              seqValue;                               // 当前最大id
}
