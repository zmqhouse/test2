package com.zmq.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleService {
    public Set<String> queryAllRoleNameByusername(@Param("username") String username);
}
