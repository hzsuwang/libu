package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/11/1.
 */
@Data
public class AdminUserRoleDO extends BaseDO{
    private Long              adminId;
    private Long              roleId;
}
