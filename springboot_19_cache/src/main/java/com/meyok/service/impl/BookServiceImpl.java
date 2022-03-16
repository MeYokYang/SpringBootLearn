package com.meyok.service.impl;

import com.meyok.dao.BookDao;
import com.meyok.domain.Book;
import com.meyok.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookDao bookDao;

    //模拟缓存
//    private HashMap<Integer, Book> cache = new HashMap<>();

//    @Override
//    public Book getById(Integer id) {
//        //如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
//        Book book = cache.get(id);
//        if (book == null) {
//            book = bookDao.selectById(id);
//            cache.put(id, book);
//        }
//
//        return book;
//    }

    @Override
    //开启缓存使用，value表示放到那个存储空间，key表示以那个存储查找
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }


    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
