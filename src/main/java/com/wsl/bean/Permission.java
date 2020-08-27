package com.wsl.bean;

import lombok.Data;

@Data
public class Permission {
    private String id;
    private String permission;
    private String description;
    private int roleId;
    private int locked;
    private String role;
}
