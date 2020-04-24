/*
 * 类名称:sendMailServiceImpl.java
 * 包名称:com.macro.mall.portal.service.impl
 *
 * 修改履历:
 *      日期                修正者        主要内容
 *
 *
 *创建日期：2020/4/23 21:54
 *create by dengjie
 * Copyright (c) 2019-2019
 */
package com.macro.mall.portal.service.impl;

import com.macro.mall.portal.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 发送邮件
 */
@Service
public class SendMailServiceImpl implements SendMailService {
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean send(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {
            //执行发送
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
