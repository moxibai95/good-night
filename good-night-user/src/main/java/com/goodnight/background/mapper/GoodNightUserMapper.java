package com.goodnight.background.mapper;

import com.goodnight.background.entity.GoodNightUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
public interface GoodNightUserMapper {
    int insert(GoodNightUser record);

    int insertSelective(GoodNightUser record);

    GoodNightUser findUserByToken(Map searchMap);
}