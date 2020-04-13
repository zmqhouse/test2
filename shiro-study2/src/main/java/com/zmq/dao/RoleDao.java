package com.zmq.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleDao {
    public Set<String> queryAllRoleNameByusername(@Param("username") String username);
}
