package com.meyok.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    //配置监听器，队列中有元素就消费
    @JmsListener(destination = "order.queue.id")
    //设置消息队列消费后可以添加新的消息队列，添加的内容是方法的返回值
    @SendTo("order.other.queue.id")
    public String receive(String id) {
        System.out.println("已完成短信发送业务，id" + id);
        return "new:" + id;
    }


}
