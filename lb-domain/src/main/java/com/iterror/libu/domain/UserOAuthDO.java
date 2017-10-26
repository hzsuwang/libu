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
@Table("lb_user_oauth")
@Comment("第三方登录信息表")
public class UserOAuthDO extends BaseDO {

    @Column("open_uid")
    @Comment("第三方提供id")
    private String  openUid;    // 第三方提供id

    @Column("user_id")
    @Comment("本系统userId")
    private Long    userId;     // 本系统userId

    @Column("access_token")
    @Comment("第三方token")
    private String  accessToken;// 第三方token

    @Column("refresh_token")
    @Comment("第三方刷新token")
    private String refreshToken;// 第三方刷新token

    @Column("oauth_from")
    @Comment("1微信 2腾讯qq 3新浪微博")
    private Integer oAuthFrom;  // 1微信 2腾讯qq 3新浪微博

    @Column("unionid")
    @Comment("微信登录统一平台账号id")
    private String  unionid;    // 微信登录统一平台账号id
}
