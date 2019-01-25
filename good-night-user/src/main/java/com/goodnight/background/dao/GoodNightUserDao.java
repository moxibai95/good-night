package com.goodnight.background.dao;

import com.goodnight.background.entity.GoodNightUser;
import com.goodnight.background.mapper.GoodNightUserMapper;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GoodNightUserDao {

    @Autowired
    private GoodNightUserMapper goodNightUserMapper;

    public void save(GoodNightUser goodNightUser) {
        goodNightUserMapper.insertSelective(goodNightUser);
    }

    public GoodNightUser findUserByToken(UsernamePasswordToken token) {
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("userName", token.getUsername());
        searchMap.put("password", String.valueOf(token.getPassword()));
        GoodNightUser goodNightUser = goodNightUserMapper.findUserByToken(searchMap);
        return goodNightUser;
    }
}
