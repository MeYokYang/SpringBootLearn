package com.meyok.service.impl;

import com.meyok.domain.SMSCode;
import com.meyok.service.ISMSCodeService;
import com.meyok.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements ISMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
//    @Cacheable(value = "smsCode", key = "#tele")
    @CachePut(value = "smsCode", key = "#tele") //只能放不能取,用来多次生成验证码时保证存入的是最后一个
    public String sendCodeToSMS(String tele) {
        return codeUtils.generator(tele);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        return cacheCode.equals(code);
    }




}
