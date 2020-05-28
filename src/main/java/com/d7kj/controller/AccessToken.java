package com.d7kj.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class AccessToken {
    private String token;
    private Date expireTime;
}
