package com.zmq.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface PermissionDao {
    public Set<String> queryAllPermissionNameByusername(@Param("username") String username);
}
