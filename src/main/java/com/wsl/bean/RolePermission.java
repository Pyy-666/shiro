package com.wsl.bean;

import lombok.Data;

@Data
public class RolePermission {
    private int id;
    private int roleId;
    private int permissionId;
}
