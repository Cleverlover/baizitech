package com.baizitech.server.system.service;

import com.baizitech.common.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author zhengwei.chen
 * @date 2021/4/28 10:50
 */
public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}