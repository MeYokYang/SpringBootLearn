package com.meyok.service.impl.base;

import com.meyok.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//@Service
public class MessageServiceImpl implements MessageService {

    private ArrayList<String> msgList = new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已经纳入处理队列，id：" + id);
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String id = msgList.remove(0);
        System.out.println("已完成短信发送业务，id：" + id);
        return null;
    }
}
