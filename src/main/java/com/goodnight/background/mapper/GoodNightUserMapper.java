package com.goodnight.background.mapper;

import com.goodnight.background.entity.GoodNightUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface GoodNightUserMapper {
    int insert(GoodNightUser record);

    int insertSelective(GoodNightUser record);
}