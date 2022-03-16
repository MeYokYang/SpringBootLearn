package com.meyok.service;

import com.meyok.domain.SMSCode;

public interface ISMSCodeService {
    String sendCodeToSMS(String tele);
    boolean checkCode(SMSCode smsCode);
}
