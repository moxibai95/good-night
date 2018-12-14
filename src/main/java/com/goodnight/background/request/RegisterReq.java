package com.goodnight.background.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterReq implements Serializable {
    /**
     *  登录名
     */
    private String loginAccount;

    /**
     *  密码
     */
    private String password;
}
