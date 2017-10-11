package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;

/**
 * Created by tony.yan on 2017/10/11.
 */
public class ContactDO extends BaseDO {

    private String name;      //联系人名称
    private String contactBak;//联系人备注
    private long   groupId;   //联系人分组
}
