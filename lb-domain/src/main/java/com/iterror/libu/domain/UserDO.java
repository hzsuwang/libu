package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/10/10.
 */
@Data
public class UserDO extends BaseDO {
    private String            phone;                                   // 手机号
    private String            password;                                // 密码
    private Integer           gender;                                  // 性别
    private Integer           status;                                  // 状态 1：正常用户 0：无效用户
    private Integer           oauthFrom;                               // 0手机登录 1微信登录
}
