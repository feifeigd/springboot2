package com.d7kj.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/// 分布式锁
public class RedisLock {

    static final Long RELEASE_SUCCESS = 1L;

    /**
     * 获取分布式锁
     * @param jedis Redis 客户端
     * @param localKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return boolean
     */
    public static boolean lock(Jedis jedis, String localKey, String requestId, int expireTime){
        SetParams params = new SetParams();
        params.nx().px(expireTime);
        if ("1".equals( jedis.set(localKey, requestId, params))){
            return  true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param jedis Redis 客户端
     * @param localKey 锁
     * @param requestId 请求标识
     * @return boolean
     */
    public static boolean unlock(Jedis jedis, String localKey, String requestId){
        String lua = "if redis.call('get', KEYS[1]) == ARG[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(lua, Collections.singletonList(localKey), Collections.singletonList(requestId));
        if(RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
}
