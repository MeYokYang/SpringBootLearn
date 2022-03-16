package com.meyok.service.impl;

import com.meyok.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SendMailServiceImpl implements SendMailService {


    @Autowired
    private JavaMailSender javaMailSender;


    //发送人
    private String from = "2553774545@qq.com";
    //收件人
    private String to = "meyokyang@163.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "测试邮件正文内容";

    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
        message.setFrom(from+"(MeYok)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        //设置定时发送
//        message.setSentDate();
        javaMailSender.send(message);
    }





























}
