package com.d7kj.controller;

import lombok.Data;

@Data
public class TokenInfo {
    // token类型，api:0, user:1
    private Integer tokenType;
    private AppInfo appInfo;
    private UserInfo userInfo;
}
