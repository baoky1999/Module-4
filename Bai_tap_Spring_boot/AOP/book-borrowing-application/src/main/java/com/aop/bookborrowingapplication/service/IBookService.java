package com.aop.bookborrowingapplication.service;

import com.aop.bookborrowingapplication.model.Book;
import com.aop.bookborrowingapplication.model.Borrow;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Optional<Book> findById(int id);

    void save(Book book);
}
