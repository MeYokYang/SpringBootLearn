package com.meyok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate template;

    @Test
    void get() {
        ValueOperations<String, String> ops = template.opsForValue();
        String username = ops.get("username");
        System.out.println(username);
    }



}
