package com.meyok.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    private String[] patch = {"00000", "0000", "000", "00", "0", ""};

    public String generator(String tele) {
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        return patch[codeStr.length()-1] + codeStr;

    }

    //会自己返回缓存，如无则返回null
    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele) {
        return null;
    }

}
