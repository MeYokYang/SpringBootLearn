package com.meyok.controller;

import com.meyok.domain.Book;
import com.meyok.service.IBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private IBookService bookService;

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }
    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }
    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }


}
