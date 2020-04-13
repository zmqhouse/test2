package com.zmq.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface PermissionService {
    public Set<String> queryAllPermissionNameByusername(@Param("username") String username);
}
