package com.d7kj.redis;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Data
public class RequestLimitConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    // 最大请求次数
    private long limit;

    // 时间
    private long time;

    // 时间单位
    private TimeUnit timeUnit;

    public RequestLimitConfig(){
        super();
    }

    public RequestLimitConfig(long limit, long time, TimeUnit timeUnit){
        this();
        this.limit = limit;
        this.time = time;
        this.timeUnit = timeUnit;
    }

    @Override
    public String toString(){
        return "RequestLimitConfig [limit=" + limit + ", time=" + time + ", timeUnit=" + timeUnit + "]";
    }
}
