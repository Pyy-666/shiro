package com.wsl.service;

import com.wsl.bean.Permission;
import com.wsl.bean.User;

import java.util.List;
import java.util.Set;

public interface LoginService{

    User getUser(String userName);

    List<Permission> getPermission(String userName);
}
