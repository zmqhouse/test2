package com.zmq.service;

import com.zmq.dao.RoleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    @Override
    public Set<String> queryAllRoleNameByusername(String username) {
        Set<String> list = roleDao.queryAllRoleNameByusername(username);
        return list;
    }
}
