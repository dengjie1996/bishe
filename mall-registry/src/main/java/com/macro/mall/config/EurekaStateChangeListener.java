/*
 * 类名称:EurekaStateChangeListener.java
 * 包名称:com.macro.mall.config
 *
 * 修改履历:
 *      日期                修正者        主要内容
 *
 *
 *创建日期：2020/4/11 22:56
 *create by dengjie
 * Copyright (c) 2019-2019
 */
package com.macro.mall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class EurekaStateChangeListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        logger.warn("服务断线了 =_= :{}", eurekaInstanceCanceledEvent.toString());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        logger.warn(" 有新的服务上线了 >_> : {}", event.toString());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        logger.warn(" 服务续约 O_O : appName = {},serverId = {}", event.getAppName(), event.getServerId());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.warn(" 注册中心启动事件 !_！ : {}", event.toString());
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        logger.warn(" 注册中心Server启动 》》》_》》》！ : {}", event.toString());
    }
}