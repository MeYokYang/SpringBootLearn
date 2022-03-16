package com.meyok.service.impl;

import com.meyok.service.IMsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements IMsgService {

    private HashMap<String, String> cache = new HashMap<>();

    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length() - 6);
        cache.put(tele, code);
        return code;
    }

    @Override
    public boolean check(String tele, String code) {

        String queryCode = cache.get(tele);
        return code.equals(queryCode);
    }
}
