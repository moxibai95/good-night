package com.goodnight.background.config;

public enum ResponesCode {
    SUCCESS(200, "返回成功"),
    FAIL(400, "返回失败"),
    LOGINSUCCESS(201, "登录成功"),
    REGISTERSUCCESS(202, "注册成功"),
    LOGINFAIL(401, "登录失败，请检查您的用户名或密码！");

    private Integer code;
    private String codeMsg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    ResponesCode(Integer code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }
}
