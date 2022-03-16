package com.meyok.service.impl;

import com.meyok.domain.Book;
import com.meyok.mapper.BookDao;
import com.meyok.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }
}
