package com.goodnight.background.dao;

import com.goodnight.background.entity.GoodNightUser;
import com.goodnight.background.mapper.GoodNightUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodNightUserDao {

    @Autowired
    private GoodNightUserMapper goodNightUserMapper;

    public void save(GoodNightUser goodNightUser) {
        goodNightUserMapper.insertSelective(goodNightUser);
    }
}
