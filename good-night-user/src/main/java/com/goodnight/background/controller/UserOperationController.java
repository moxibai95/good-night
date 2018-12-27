package com.goodnight.background.controller;

import com.goodnight.background.entity.GoodNightUser;
import com.goodnight.background.request.RegisterReq;
import com.goodnight.background.respones.BaseRespones;
import com.goodnight.background.service.GoodNightUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return BaseRespones.Success();
    }
}
