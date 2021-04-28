package com.baizitech.auth.manager;

import com.baizitech.common.entity.system.Menu;
import com.baizitech.common.entity.system.SystemUser;
import com.baizitech.auth.mapper.MenuMapper;
import com.baizitech.auth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        SystemUser systemUser = userMapper.findByName(username);
        return systemUser;
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
