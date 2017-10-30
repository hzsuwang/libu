package com.iterror.libu.doc.service;

import com.iterror.libu.domain.ResourceDO;

/**
 * Created by tony.yan on 2017/10/29.
 */
public interface ResourceService {

    /**
     *
     * @param code
     * @return
     */
    public ResourceDO getCashResourceByCode(String code);

    /**
     * @param code
     * @return
     */
    public ResourceDO getResourceByCode(String code);

    /**
     * 根据ID获取资源
     * 
     * @param id
     * @return
     */
    public ResourceDO getResourceById(long id);

    /**
     * 更新资源
     * 
     * @param resource
     * @return
     */
    public int update(ResourceDO resource);

    /**
     * 插入一条新的资源记录
     *
     * @param resourceDO
     * @return 资源记录Id
     */
    public long addResourceRecord(ResourceDO resourceDO);

    /**
     * 清除内存中的数据
     */
    public void clearCashData();
}
