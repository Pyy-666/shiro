package com.wsl.service.impl;

import com.wsl.bean.Permission;
import com.wsl.bean.User;
import com.wsl.mapper.userMapper;
import com.wsl.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    userMapper mapper;

    @Override
    public User getUser(String userName) {
        return mapper.getUser(userName);
    }

    @Override
    public List<Permission> getPermission(String userName) {
        return mapper.getPermission(userName);
    }
}
