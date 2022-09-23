package com.nikfce.wht.work.hard.tool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenzhencheng 2022/9/21
 * @date 2022/09/21
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    public Object index() {
        return "ok";
    }

}
