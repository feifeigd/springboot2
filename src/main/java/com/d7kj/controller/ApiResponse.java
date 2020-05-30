package com.d7kj.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class ApiResponse<T> {
    private ApiResult result;
    private T data;
    private String sign;

    public static <T> ApiResponse<T> success(T data){
        return response(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ApiResponse<T> error(String code, String msg, T data){
        return response(code, msg, null);
    }

    public static <T> ApiResponse<T> response(String code, String msg, T data){
        ApiResult result = new ApiResult(code, msg);
        ApiResponse<T> response = new ApiResponse<T>();
        response.setResult(result);
        response.setData(data);

        String sign = signData(data);
        response.setSign(sign);

        return response;
    }

    private static <T> String signData(T data){
        // TODO 要查询得到
        String key = "123458";
        Map<String, String> responseMap = null;
        try {
            responseMap = getFields(data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        String urlComponent = ApiUtil.concatSignString(responseMap);
        String signature = urlComponent + "key=" + key;
        return MD5Util.encode(signature);
    }

    public static Map<String, String> getFields(Object data) throws IllegalAccessException {
        if (data == null)return null;
        Map<String, String> map = new HashMap<>();
        Field[] fields = data.getClass().getDeclaredFields();

        for (Field field :
                fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(data);
            if (value != null){
                map.put(name, value.toString());
            }
        }
        return map;
    }
}
