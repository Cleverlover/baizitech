package com.baizitech.auth.mapper;

import com.baizitech.common.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}
