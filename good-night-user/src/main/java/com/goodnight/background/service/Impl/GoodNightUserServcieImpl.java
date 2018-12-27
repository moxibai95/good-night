package com.goodnight.background.service.Impl;

import com.goodnight.background.dao.GoodNightUserDao;
import com.goodnight.background.entity.GoodNightUser;
import com.goodnight.background.service.GoodNightUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class GoodNightUserServcieImpl implements GoodNightUserService {

    @Autowired
    private GoodNightUserDao goodNightUserDao;

    @Override
    public void register(GoodNightUser user) {
        String uid = UUID.randomUUID().toString().replace("-", "");
        user.setUid(uid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreateTime(df.format(new Date()));
        user.setLastModifyTime(System.currentTimeMillis());
        goodNightUserDao.save(user);
    }
}
