package com.ldk.sprincloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.ldk.sprincloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @class: MessageProviderImpl
 * @author:
 * @date: 2020/12/17 11:02
 * @description: impl
 */
@EnableBinding(Source.class)//定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial"+ serial);
        return null;
    }
}
