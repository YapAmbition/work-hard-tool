package com.nikfce.wht.work.hard.tool.dao.manager;

import com.nikfce.wht.work.hard.tool.dao.entity.UserTb;
import com.nikfce.wht.work.hard.tool.dao.mapper.UserTbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shenzhencheng 2022/9/23
 */
@Component
public class UserManager {

    @Autowired
    private UserTbMapper userTbMapper;

    @Transactional(rollbackFor = Throwable.class)
    public int insertUser(UserTb userTb) {
        return userTb == null ? 0 : userTbMapper.insertSelective(userTb);
    }

}
