package com.goodnight.background.respones;

import lombok.Data;

@Data
public class BaseRespones<T> {
    /**
     *  状态码
     */
    private String statusCode;

    /**
     *  返回信息
     */
    private String message;

    /**
     *  返回数据
     */
    private T data;

    public static BaseRespones Success() {
        BaseRespones baseRespones = new BaseRespones();
        baseRespones.setStatusCode("1");
        baseRespones.setMessage("请求成功");
        return baseRespones;
    }
}
