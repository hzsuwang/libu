package com.iterror.libu.common.dao.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class BaseDO implements java.io.Serializable{

    private Long id;

    private Integer deleted;

    private Date createTime;

    private Date editTime;
}
