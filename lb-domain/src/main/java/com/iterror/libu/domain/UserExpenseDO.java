package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */

/**
 * 当前用户支出
 */
@Data
@Table("lb_user_expense")
@Comment("用户记录表")
public class UserExpenseDO extends BaseDO {

    @Column("user_id")
    @Comment("用户id")
    private long   userId;     // 用户id

    @Column("contact_id")
    @Comment("联系人id")
    private long   contactId;  // 联系人id

    @Column("money")
    @Comment("随礼金额")
    private int    money;      // 随礼金额

    @Column("event_name")
    @Comment("事件说明")
    private String eventName;  // 事件说明

    @Column("expense_bak")
    @Comment("支出备注")
    private String expenseBak; // 支出备注

    @Column("expense_time")
    @Comment("支出时间")
    private Date   expenseTime;// 支出时间
}
