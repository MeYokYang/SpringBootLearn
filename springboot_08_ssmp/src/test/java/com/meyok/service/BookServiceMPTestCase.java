package com.meyok.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meyok.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BookServiceMPTestCase {

    @Resource(name = "bookServiceImpl_MP")
    private IBookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(5));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据747");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(18);
        book.setType("测试数据456");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.updateById(book);
    }

    @Test
    void testDelete() {
        bookService.removeById(12);
    }

    @Test
    void testGetALL() {
        bookService.list();
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}
