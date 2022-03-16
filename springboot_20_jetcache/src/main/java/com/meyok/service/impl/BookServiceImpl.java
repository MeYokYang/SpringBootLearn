package com.meyok.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.meyok.dao.BookDao;
import com.meyok.domain.Book;
import com.meyok.service.IBookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookDao bookDao;


    //使用方法缓存时，要在相应的配置中声明keyConvertor，并且返回类要序列化，配置中要声明valueEncode和valueDecode
    @Override
    @Cached(name = "book_", key = "#id", expire = 3600)
    @CacheRefresh(refresh = 5) //每10秒刷新缓存来同步，防止多系统访问后，其中一个改数据，其他缓存使用旧数据情况
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }


    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
