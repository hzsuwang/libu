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
@Table("lb_cash_profuct")
@Comment("用户表")
public class CashProductDO extends BaseDO {

    @Column("name")
    @Comment("商品名称")
    private String name;          // 商品名称

    @Column("prize")
    @Comment("商品价格")
    private int    prize;         // 商品价格

    @Column("num")
    @Comment("数量")
    private int    num;           // 数量

    @Column("order_num")
    @Comment("显示顺序")
    private int    orderNum;      // 显示顺序

    @Column("description")
    @Comment(" 描述")
    private String description;   // 描述

    @Column("thirdparty_pid")
    @Comment("第三方产品id")
    private String thirdpartyPid; // 第三方产品id

    @Column("pro_type")
    @Comment("商品类型")
    private int    proType;       // 商品类型

    @Column("icon")
    @Comment(" 图标")
    private String icon;          // 图标

    @Column("channel")
    @Comment("渠道")
    private String channel;       // 渠道

}
