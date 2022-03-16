package com.meyok;

import com.meyok.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


//properties:test中临时加的属性,application.yml中也有会覆盖
//args:可以为当前测试用例添加临时的命令行参数
@SpringBootTest(properties = {"test.prop = testValue1"}, args = {"--test.prop2 =testValue2"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Value("${test.prop2}")
    private String msg2;

    @Resource
    private BookCase bookCase;

    @Test
    void testProperties() {
        System.out.println(msg);
        System.out.println(msg2);
        System.out.println(bookCase);
    }



}
