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
@Table("lb_cash_flow")
@Comment("用户表")
public class CashFlowDO extends BaseDO {

    @Column("pro_prize")
    @Comment("产品的价格")
    private int    proPrize;    // 产品的价格

    @Column("pid")
    @Comment("产品id")
    private int    pid;         // 产品id

    @Column("product_name")
    @Comment("产品名称")
    private String productName; // 产品名称

    @Column("user_id")
    @Comment("用户id")
    private long   userId;      // 用户id

    @Column("num")
    @Comment("数量")
    private int    num;         // 数量

    @Column("tp_trade_id")
    @Comment("第三方订单id")
    private String tpTradeId;   // 第三方订单id

    @Column("source")
    @Comment("1 支付宝 2微信支付 3银联支付 4苹果内支付")
    private int    source;      // 1 支付宝 2微信支付 3银联支付 4苹果内支付

    @Column("status")
    @Comment("状态 0 创建 1成功")
    private int    status;      // 状态 0 创建 1成功

    @Column("pay_desc")
    @Comment("支付描述")
    private String payDesc;     // 支付描述

    @Column("client")
    @Comment("客户端类型:1 iOS 2 Android 3 WinPhone")
    private int    client;      // 客户端类型:1 iOS 2 Android 3 WinPhone

    @Column("pay_money")
    @Comment("用户实际充值金额")
    private int    payMoney;    // 用户实际充值金额

    @Column("cash_type")
    @Comment("商品类型")
    private int    cashType;    // 商品类型

    @Column("order_id")
    @Comment("自已服务器的订单号")
    private String orderId;     // 自已服务器的订单号

    @Column("client_ver")
    @Comment("客户端版本号")
    private String clientVer;   // 客户端版本号

    @Column("device")
    @Comment("机型")
    private String device;      // 机型

}
