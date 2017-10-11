package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class UserOAuthDO extends BaseDO {

    private String  openUid;    // 第三方提供id
    private Long    userId;     // 本系统userId
    private String  accessToken;// 第三方token
    private Integer oAuthFrom;  // 1微信 2腾讯qq 3新浪微博
    private String  unionid;    // 微信登录统一平台账号id
}
