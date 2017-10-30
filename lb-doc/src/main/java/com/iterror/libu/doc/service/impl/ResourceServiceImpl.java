package com.iterror.libu.doc.service.impl;

import com.iterror.libu.common.service.BaseService;
import com.iterror.libu.doc.service.ResourceService;
import com.iterror.libu.domain.ResourceDO;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tony.yan on 2017/10/29.
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseService implements ResourceService {

    /**
     * 十分钟自动清理一次
     */
    private static ConcurrentHashMap<String, ResourceDO> reMap = new ConcurrentHashMap<String, ResourceDO>();

    @Override
    public ResourceDO getCashResourceByCode(String code) {
        ResourceDO resourceDO = reMap.get(code);
        if (resourceDO != null) {
            return resourceDO;
        }
        resourceDO = getResourceByCode(code);
        if (resourceDO != null) {
            reMap.put(code, resourceDO);
        }
        return resourceDO;
    }

    @Override
    public ResourceDO getResourceByCode(String code) {
        return dao.fetch(ResourceDO.class, Cnd.where("code", "=", code));
    }

    @Override
    public ResourceDO getResourceById(long id) {
        return dao.fetch(ResourceDO.class, id);
    }

    @Override
    public int update(ResourceDO resource) {
        return dao.update(resource);
    }

    @Override
    public long addResourceRecord(ResourceDO resourceDO) {
        ResourceDO newResourceDO = dao.insert(resourceDO);
        return newResourceDO.getId();
    }

    @Override
    public void clearCashData() {
        reMap.clear();
    }
}
