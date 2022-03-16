package com.meyok.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.meyok.domain.SMSCode;
import com.meyok.service.ISMSCodeService;
import com.meyok.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements ISMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @CreateCache(name = "jetCache_", expire = 1000, cacheType = CacheType.LOCAL) //expire默认单位秒,cacheType默认远程
    private Cache<String, String > jetCache;

    @CreateCache(area = "sms", name = "jetCache2_", expire = 10) //expire默认单位秒
    private Cache<String, String > jetCache2;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }




}
