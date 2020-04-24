/*
 * 类名称:TestController.java
 * 包名称:com.mall.front.web.controller
 *
 * 修改履历:
 *      日期                修正者        主要内容
 *
 *
 *创建日期：2020/4/21 20:33
 *create by dengjie
 * Copyright (c) 2019-2019
 */
package com.mall.front.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(@RequestParam String param) {
        return param;
    }
}
