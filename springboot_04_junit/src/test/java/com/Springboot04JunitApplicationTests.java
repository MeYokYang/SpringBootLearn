package com;

import com.meyok.Springboot04JunitApplication;
import com.meyok.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//若测试类Application不在源引导类Application的包及其子包下，需要添加classes来指定源Application。如果不使用classes属性，也可以使用ContextConfiguration注解
@SpringBootTest(classes = Springboot04JunitApplication.class)
//@ContextConfiguration(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {

    //1.注入要测试的对象
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        //2.执行要测试的对象相应的方法
        bookDao.save();
    }

}
