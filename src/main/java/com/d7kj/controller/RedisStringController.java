package com.d7kj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/strredis")
public class RedisStringController {

    @Autowired
    StringRedisTemplate redisClient;

    @RequestMapping("/setget.html")
    public @ResponseBody String env(String para)throws Exception{
        ValueOperations<String, String> redis = redisClient.opsForValue();
        redis.set("testenv", para);
        return redis.get("testenv");
    }
}
