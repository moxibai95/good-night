package com.goodnight.background.controller;

import com.goodnight.background.config.ResponesCode;
import com.goodnight.background.entity.GoodNightUser;
import com.goodnight.background.request.RegisterReq;
import com.goodnight.background.respones.BaseRespones;
import com.goodnight.background.service.GoodNightUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.shiro.authc.UsernamePasswordToken;


@RestController
@RequestMapping("/good/night/user")
public class UserOperationController {

    @Autowired
    private GoodNightUserService goodNightUserService;

    @RequestMapping("/register")
    public BaseRespones register(@RequestBody RegisterReq registerReq) {
        GoodNightUser user = new GoodNightUser();
        user.setLoginAccount(registerReq.getLoginAccount());
        user.setPassword(registerReq.getPassword());
        goodNightUserService.register(user);
        return BaseRespones.responesByEnum(ResponesCode.REGISTERSUCCESS);
    }

    @RequestMapping("/login")
    public BaseRespones login(@RequestBody RegisterReq registerReq) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken userPasswordTokenVO = new UsernamePasswordToken(registerReq.getLoginAccount(), registerReq.getPassword());
        try {
            subject.login(userPasswordTokenVO);
        }catch (AuthenticationException e) {
            return BaseRespones.responesByEnum(ResponesCode.LOGINFAIL);
        }
        return BaseRespones.responesByEnum(ResponesCode.LOGINSUCCESS);
    }
}
