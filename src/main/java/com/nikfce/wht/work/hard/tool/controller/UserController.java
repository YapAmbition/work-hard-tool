package com.nikfce.wht.work.hard.tool.controller;

import com.alibaba.fastjson2.JSON;
import com.nikfce.wht.work.hard.tool.dto.CommonResponse;
import com.nikfce.wht.work.hard.tool.dto.SignUpRequest;
import com.nikfce.wht.work.hard.tool.service.UserService;
import com.nikfce.wht.work.hard.tool.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenzhencheng 2022/9/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public CommonResponse<Long> signUp(@RequestBody SignUpRequest request) {
        if (request == null
                || StringUtil.isEmpty(request.getEmail())
                || StringUtil.isEmpty(request.getNickName())
                || StringUtil.isEmpty(request.getPassword())
        ) {
            return CommonResponse.ofFailed("email, nickName, password不能为空");
        }
        try {
            return userService.signUp(request.getEmail().trim(), request.getNickName().trim(), request.getPassword().trim());
        } catch (Exception e) {
            LOG.error("注册用户失败, request: {}", JSON.toJSONString(request), e);
            return CommonResponse.ofFailed("注册失败, " + e.getMessage());
        }
    }

}
