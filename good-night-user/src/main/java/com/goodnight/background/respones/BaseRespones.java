package com.goodnight.background.respones;

import com.goodnight.background.config.ResponesCode;
import lombok.Data;

@Data
public class BaseRespones<T> {
    /**
     *  状态码
     */
    private Integer statusCode;

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
        baseRespones.setStatusCode(200);
        baseRespones.setMessage("请求成功");
        return baseRespones;
    }

    public static BaseRespones Success(String message) {
        BaseRespones baseRespones = new BaseRespones();
        baseRespones.setStatusCode(200);
        baseRespones.setMessage(message);
        return baseRespones;
    }

    public static BaseRespones responesByEnum(ResponesCode responesCode) {
        BaseRespones baseRespones = new BaseRespones();
        baseRespones.setStatusCode(responesCode.getCode());
        baseRespones.setMessage(responesCode.getCodeMsg());
        return baseRespones;
    }
}
