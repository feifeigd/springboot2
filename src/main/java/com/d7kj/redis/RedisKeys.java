package com.d7kj.redis;

public interface RedisKeys {
    /**
     * api 的限制配置,hash key
     */
    String REQUEST_LIMIT_CONFIG = "request_limit_config";

    /**
     * api 的请求的次数
     */
    String REQUEST_LIMIT = "request_limit";
}
