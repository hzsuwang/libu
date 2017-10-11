package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class ContactGroupDO extends BaseDO {

    private String name;    // 分组名称
    private String groupBak;// 分组备注
}
