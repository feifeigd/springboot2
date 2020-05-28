package com.d7kj.controller;

import lombok.Data;

@Data
public class UserInfo {
    private String username;
    private String mobile;
    private String email;
    private String password;
    private String salt;
    private AccessToken accessToken;

    public UserInfo(String username, String password, String salt){
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
}
