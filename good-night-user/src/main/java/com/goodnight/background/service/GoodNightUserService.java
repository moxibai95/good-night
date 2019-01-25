package com.goodnight.background.service;

import com.goodnight.background.entity.GoodNightUser;
import org.apache.shiro.authc.UsernamePasswordToken;

public interface GoodNightUserService {

    void register(GoodNightUser user);

    GoodNightUser findUserByToken(UsernamePasswordToken token);
}
