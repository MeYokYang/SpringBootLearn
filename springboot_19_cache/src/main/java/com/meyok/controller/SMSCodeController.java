package com.meyok.controller;

import com.meyok.domain.SMSCode;
import com.meyok.service.ISMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private ISMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tele) {
        return smsCodeService.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }



}
