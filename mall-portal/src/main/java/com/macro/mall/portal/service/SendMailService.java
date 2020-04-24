/*
 * 类名称:sendMailService.java
 * 包名称:com.macro.mall.portal.service
 *
 * 修改履历:
 *      日期                修正者        主要内容
 *
 *
 *创建日期：2020/4/23 21:53
 *create by dengjie
 * Copyright (c) 2019-2019
 */
package com.macro.mall.portal.service;

public interface SendMailService {
    boolean send(String to, String subject, String content);
}
