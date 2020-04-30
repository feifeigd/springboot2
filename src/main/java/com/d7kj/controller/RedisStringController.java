package com.d7kj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/strredis")
public class RedisStringController {

    @RequestMapping("/setget.html")
    public @ResponseBody String env(String para)throws Exception{
        return "";
    }
}
