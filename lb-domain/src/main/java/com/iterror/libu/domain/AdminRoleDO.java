package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/11/1.
 */
@Data
public class AdminRoleDO extends BaseDO{
    private String            name;
    private int               type;
}
