package com.wsl.mapper;

import com.wsl.bean.Permission;
import com.wsl.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface userMapper {
    User getUser(String userName);

    List<Permission> getPermission(String userName);
}
