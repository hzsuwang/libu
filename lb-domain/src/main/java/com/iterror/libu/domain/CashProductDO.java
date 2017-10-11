package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class CashProductDO extends BaseDO {

    private String name;          // 商品名称
    private int    prize;         // 商品价格
    private int    num;           // 数量
    private int    orderNum;      // 显示顺序
    private String description;   // 描述
    private String thirdpartyPid; // 第三方产品id
    private int    payType;       // 支付类型0普能支付 1表示ios内支付
    private int    proType;       // 商品类型
    private String icon;          // 图标
    private String channel;       // 渠道
}
