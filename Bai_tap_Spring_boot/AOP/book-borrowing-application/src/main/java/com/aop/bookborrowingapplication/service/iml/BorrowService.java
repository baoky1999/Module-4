package com.aop.bookborrowingapplication.service.iml;

import com.aop.bookborrowingapplication.model.Borrow;
import com.aop.bookborrowingapplication.repository.IBorrowRepository;
import com.aop.bookborrowingapplication.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BorrowService implements IBorrowService {

    @Autowired
    private IBorrowRepository borrowRepository;

    @Override
    public boolean existsByCode(String randomCode) {
        return borrowRepository.existsByCode(randomCode);
    }

    @Override
    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public Borrow findByCode(String code) {
        return borrowRepository.findByCode(code);
    }

    @Override
    public void delete(Borrow borrow) {
        borrowRepository.delete(borrow);
    }

    @Override
    public Optional<Borrow> findById(int id) {
        return borrowRepository.findById(id);
    }
}
