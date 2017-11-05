package com.iterror.libu.admin.service.impl;

import com.iterror.libu.admin.service.AdminUserService;
import com.iterror.libu.common.service.BaseService;
import com.iterror.libu.domain.AdminUserDO;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

/**
 * Created by tony.yan on 2017/11/5.
 */
@Service("adminUserService")
public class AdminUserServiceImpl extends BaseService implements AdminUserService {

    @Override
    public AdminUserDO getById(long userId) {
        return dao.fetch(AdminUserDO.class, userId);
    }

    @Override
    public boolean forbiddenUser(long userId) {
        int row = dao.update(AdminUserDO.class, Chain.make("status", 0), Cnd.where("id", "=", userId));
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public AdminUserDO getByName(String name) {
        return dao.fetch(AdminUserDO.class, Cnd.where("user_name", "=", name));
    }

    @Override
    public int updateAdminUser(AdminUserDO adminUserDO) {
        return dao.update(adminUserDO);
    }
}
