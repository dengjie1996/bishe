/*
 * 类名称:CommandOpenChrome.java
 * 包名称:com.macro.mall.config
 *
 * 修改履历:
 *      日期                修正者        主要内容
 *
 *
 *创建日期：2020/4/4 15:20
 *create by dengjie
 * Copyright (c) 2019-2019
 */
package com.mall.front.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 在项目启动后会自动扫描CommandLineRunner 实现类中的run 方法，并执行。
 **/
@Component
public class CommandOpenChrome implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        if (true) {
            //接口文档
            String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" + " " + "http://localhost:8080/html/index.html";
            Runtime run = Runtime.getRuntime();
            try {
                run.exec(cmd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
