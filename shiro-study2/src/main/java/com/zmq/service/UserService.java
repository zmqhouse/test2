package com.zmq.service;

import com.zmq.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    public User queryAllUserByUsername(@Param("username") String username);
    int insertAddUser(User user);
}
