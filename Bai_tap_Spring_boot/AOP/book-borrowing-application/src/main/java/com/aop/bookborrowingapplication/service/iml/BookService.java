package com.aop.bookborrowingapplication.service.iml;

import com.aop.bookborrowingapplication.model.Book;
import com.aop.bookborrowingapplication.repository.IBookRepository;
import com.aop.bookborrowingapplication.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
