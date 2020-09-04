package com.d7kj.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/// 限流器
@Slf4j
public class RequestLimitInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private ObjectRedisTemplate objectRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 获取到请求的URI
        String contentPath = request.getContextPath();
        String uri = request.getRequestURI().toString();
        if (!StringUtils.isEmpty(contentPath) && !contentPath.equals("/")){
            uri = uri.substring(uri.indexOf(contentPath) + contentPath.length());
        }
        log.info("uri={}", uri);
        // 尝试从hash中读取得到当前接口的限流配置
        RequestLimitConfig requestLimitConfig = (RequestLimitConfig)this.objectRedisTemplate.opsForHash().get(RedisKeys.REQUEST_LIMIT_CONFIG, uri);
        if (requestLimitConfig == null){
            log.info("该uri={}没有限流配置", uri);
            return true;
        }

        String limitKey = RedisKeys.REQUEST_LIMIT + ":" + uri;

        // 当前接口的访问次数 +1
        long count = this.objectRedisTemplate.opsForValue().increment(limitKey);
        if (count == 1){
            // 第一次请求,设置key的过期时间
            this.objectRedisTemplate.expire(limitKey, requestLimitConfig.getTime(), requestLimitConfig.getTimeUnit());
            log.info("设置过期时间：time={}, timeUnit={}", requestLimitConfig.getTime(), requestLimitConfig.getTimeUnit());
        }

        log.info("请求限制。limit={}, count={}", requestLimitConfig.getLimit(), count);
        if (count > requestLimitConfig.getLimit()){
            // 限定时间内，请求超出限制，响应客户端错误信息
            response.setContentType(MediaType.TEXT_PLAIN_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write("服务器繁忙，稍后再试");
            return false;
        }
        return true;
    }
}
