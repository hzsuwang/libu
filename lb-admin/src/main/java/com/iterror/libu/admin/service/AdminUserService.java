package com.iterror.libu.admin.service;

import com.iterror.libu.domain.AdminUserDO;

/**
 * Created by tony.yan on 2017/11/5.
 */
public interface AdminUserService {

    /**
     * @param userId
     * @return
     */
    public AdminUserDO getById(long userId);

    /**
     * @param userId
     * @return
     */
    public boolean forbiddenUser(long userId);

    /**
     * @param name
     * @return
     */
    public AdminUserDO getByName(String name);

    /**
     * @param adminUserDO
     * @return
     */
    public int updateAdminUser(AdminUserDO adminUserDO);

}
