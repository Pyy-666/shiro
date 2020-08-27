package com.wsl.bean;

import lombok.Data;

@Data
public class User {
    private String id;
    private String userName;
    private String password;
    private String salt;
    private String roleId;
    private int locked;
}
