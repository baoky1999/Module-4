package com.aop.bookborrowingapplication.repository;

import com.aop.bookborrowingapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
