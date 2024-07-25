package com.aop.bookborrowingapplication.repository;

import com.aop.bookborrowingapplication.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {

    boolean existsByCode(String name);

    Borrow findByCode(String code);
}
