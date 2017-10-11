package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */

/**
 * 当前用户支出
 */
public class UserExpenseDO extends BaseDO {

    private long   userId;     // 用户id
    private long   contactId;  // 联系人id
    private int    money;      // 随礼金额
    private String eventName;  // 事件说明
    private String expenseBak; // 支出备注
    private Date   expenseTime;// 支出时间
}
