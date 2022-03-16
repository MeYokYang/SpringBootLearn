package com.meyok;

import com.meyok.domain.Book;
import com.meyok.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@Transactional //spring添加事务
@Rollback(false) //默认为true，表示回滚
public class DaoTest {

    @Resource
    private IBookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("springboot1");
        book.setType("springboot1");
        book.setDescription("springboot1");
        bookService.save(book);
    }


}
