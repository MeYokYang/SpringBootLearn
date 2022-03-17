package com.meyok.service.impl;

import com.meyok.service.MessageService;
import com.meyok.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final MessageService messageService;

    @Autowired
    public OrderServiceImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void order(String id) {
        //一系列操作，包含各种服务调用，处理各种业务
        System.out.println("订单处理开始");
        //短信消息处理
        messageService.sendMessage(id);
        System.out.println("订单处理结束");
        System.out.println();
    }
}
