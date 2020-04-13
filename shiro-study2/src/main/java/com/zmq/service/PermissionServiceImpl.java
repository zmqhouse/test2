package com.zmq.service;

import com.zmq.dao.PermissionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public Set<String> queryAllPermissionNameByusername(String username) {
        Set<String> list = permissionDao.queryAllPermissionNameByusername(username);
        return list;
    }
}
