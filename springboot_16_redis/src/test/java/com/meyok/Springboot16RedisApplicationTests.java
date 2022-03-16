package com.meyok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot16RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("age", 41);

        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info", "a", "aa");
    }

    @Test
    void get() {
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        Object age = valueOperations.get("age");
//        System.out.println(age);

        HashOperations hashOperations = redisTemplate.opsForHash();
        Object o = hashOperations.get("info", "a");
        System.out.println(o);

    }

}
