package com.zmq.service;

import com.zmq.dao.UserDao;
import com.zmq.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User queryAllUserByUsername(String username) {
        User user = userDao.queryAllUserByUsername(username);
        return user;
    }


    @Override
    public int insertAddUser(User user) {
        //设置随机盐
        String salt = UUID.randomUUID().toString();
        //设置加密属性:sha256算法,随机盐,迭代1000次
        String s = new Sha256Hash(user.getPassword(), salt, 10000).toBase64();
        //将用户信息(包括密码的密文和盐)存入数据库
        user.setPassword(s);//密文采用base64格式化
        user.setSalt(salt);
        return userDao.insertAddUser(user);
    }
}
