package com.aop.bookborrowingapplication.service;

import com.aop.bookborrowingapplication.model.Book;
import com.aop.bookborrowingapplication.model.Borrow;

import java.util.List;
import java.util.Optional;

public interface IBorrowService {

    boolean existsByCode(String randomCode);

    void save(Borrow borrow);

    Borrow findByCode(String code);

    void delete(Borrow borrow);

    Optional<Borrow> findById(int id);
}
