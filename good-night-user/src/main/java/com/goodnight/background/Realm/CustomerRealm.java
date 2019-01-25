package com.goodnight.background.Realm;

import com.goodnight.background.entity.GoodNightUser;
import com.goodnight.background.service.GoodNightUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private GoodNightUserService goodNightUserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("---------------用户开始登陆---------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        GoodNightUser goodNightUser = goodNightUserService.findUserByToken(token);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token, goodNightUser.getPassword(), goodNightUser.getLoginAccount());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", goodNightUser);
        return authenticationInfo;
    }
}
