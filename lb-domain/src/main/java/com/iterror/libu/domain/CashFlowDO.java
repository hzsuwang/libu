package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class CashFlowDO extends BaseDO {

    private int    proPrize;    // 产品的价格
    private int    pid;         // 产品id
    private String productName; // 产品名称
    private long   userId;      // 用户id
    private int    num;         // 数量
    private String tpTradeId;   // 第三方订单id
    private int    source;      // 1 支付宝 2微信支付 3银联支付 4苹果内支付
    private int    status;      // 状态 0 创建 1成功 -1失败
    private String payDesc;     // 支付描述
    private int    client;      // 客户端类型:1 iOS 2 Android 3 WinPhone
    private int    payMoney;    // 用户实际充值金额
    private int    cashType;    // 商品类型
    private String orderId;     // 自已服务器的订单号
    private String clientVer;   // 客户端版本号
    private String device;      // 机型
}
