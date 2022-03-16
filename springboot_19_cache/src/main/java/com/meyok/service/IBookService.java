package com.meyok.service;

import com.meyok.domain.Book;

import java.util.List;

public interface IBookService {
    boolean save(Book book);
    Book getById(Integer id);
    boolean update(Book book);
    boolean delete(Integer id);
    List<Book> getAll();
}
