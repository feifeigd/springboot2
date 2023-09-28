package com.d7kj.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApiUtil {
    /**
     * 按照参数名升序拼接参数
     */
    public static String concatSignString(HttpServletRequest request){
        Map<String, String> paramterMap = new HashMap<>();
        request.getParameterMap().forEach((key, value)->paramterMap.put(key, value[0]));
        return concatSignString(paramterMap);
    }

    public static String concatSignString(Map<String, String> paramterMap){
        Set<String> keySet = paramterMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for(String k: keyArray){
            if (k.equals("sign")){
                continue;
            }
            String value = paramterMap.get(k).trim();
            if (value.length() > 0){
                sb.append(k).append("=").append(value).append("&");
            }
        }
        return sb.toString();
    }

    /**
     * 获取方法上的@NotRepeatSubmit注解
     */
    public static NotRepeatSubmit getNotRepeatSubmit(Object handler){
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            return method.getAnnotation(NotRepeatSubmit.class);
        }
        return null;
    }
}
