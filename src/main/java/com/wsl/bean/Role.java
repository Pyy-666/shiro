package com.wsl.bean;

import lombok.Data;

@Data
public class Role {
    private String id;
    private String role;
    private String description;
    private int parentId;
    private int locked;
}
