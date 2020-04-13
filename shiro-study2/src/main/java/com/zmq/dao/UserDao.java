package com.zmq.dao;

import com.zmq.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
     User queryAllUserByUsername(@Param("username") String username);
     int insertAddUser(User user);
}
