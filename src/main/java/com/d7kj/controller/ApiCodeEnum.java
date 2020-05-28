package com.d7kj.controller;

import lombok.Getter;

/**
 * 错误码code可以使用纯数字，使用不同区间标识一类错误，也可以使用纯数字，也可以使用前缀+编号
 *
 * 错误码: ERR + 编号
 * 可以使用日志级别的前缀作为错误类型区分 Info(I) Error(E) Warning(W)
 * 或者以业务模块 - 错误号
 * TODO 错误码设计
 * alipay 用了两个code 两个msg(https://docs.open.alipay.com/api_1/alipay.trade.pay)
 */
@Getter
public enum ApiCodeEnum {
    SUCCESS("10000", "success"),
    UNKNOW_ERROR("ERR0001", "未知错误"),
    PARAMETER_ERROR("ERR0002", "参数错误"),
    TOKEN_EXPIRE("ERR0003", "token过期"),
    REQUEST_TIMEOUT("ERR0004", "请求超时"),
    SIGN_ERROR("ERR0005", "签名错误"),
    REPEAT_SUBMIT("ERR0006", "请不要频繁操作"),
    ;
    String code;
    String msg;

    ApiCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
