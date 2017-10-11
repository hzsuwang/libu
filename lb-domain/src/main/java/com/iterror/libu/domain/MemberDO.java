package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class MemberDO extends BaseDO {

    private Long userId;      // 用户id
    private Date expiredTime; // 过期时间
}
