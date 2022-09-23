package com.nikfce.wht.work.hard.tool.service;

import com.nikfce.wht.work.hard.tool.dao.entity.UserTb;
import com.nikfce.wht.work.hard.tool.dao.manager.UserManager;
import com.nikfce.wht.work.hard.tool.dto.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenzhencheng 2022/9/23
 */
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserManager userManager;

    public synchronized CommonResponse<Long> signUp(String email, String nickName, String password) {
        LOG.info("signUp, email: {}, nickName: {}, password: {}", email, nickName, password);
        long serialNumber = System.currentTimeMillis();
        UserTb userTb = new UserTb();
        userTb.setEmail(email);
        userTb.setNickName(nickName);
        userTb.setPassword(password);
        userTb.setSerialNumber(serialNumber);
        int res = 0;
        for (int i = 0 ; i < 3 ; i ++) {
            res = userManager.insertUser(userTb);
            if (res > 0) {
                break;
            }
        }
        if (res == 0) {
            LOG.error("插入数据库失败, email: {}, nickName: {}, password: {}", email, nickName, password);
            return CommonResponse.ofFailed("注册失败,请过会重试");
        }
        return CommonResponse.ofSuccess(serialNumber);
    }

}
