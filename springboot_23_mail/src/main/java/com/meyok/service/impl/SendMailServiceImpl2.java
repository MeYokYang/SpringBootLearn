package com.meyok.service.impl;

import com.meyok.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl2 implements SendMailService {


    @Autowired
    private JavaMailSender javaMailSender;


    //发送人
    private String from = "2553774545@qq.com";
    //收件人
    private String to = "meyokyang@163.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "<img src='https://img.syt5.com/2020/0630/20200630024648289.jpg'/><a href='https://www.baidu.com'>嘿嘿</a>";

    @Override
    public void sendMail() {

        try {
            //发的内容需要解析html，setText中要设置true，想发送附件，MineMessageHelper要设置true
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from+"(MeYok)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);


            //添加附件
            File f1 = new File("C:\\Users\\25537\\IdeaProjects\\SpringBootLearn\\springboot_23_mail\\target\\springboot_23_mail-0.0.1-SNAPSHOT.jar");
            File f2 = new File("C:\\Users\\25537\\IdeaProjects\\SpringBootLearn\\springboot_23_mail\\src\\main\\resources\\test_picture.jpg");

            helper.addAttachment(f1.getName(), f1);
            helper.addAttachment("嘿嘿嘿.jpg", f2);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }





























}
