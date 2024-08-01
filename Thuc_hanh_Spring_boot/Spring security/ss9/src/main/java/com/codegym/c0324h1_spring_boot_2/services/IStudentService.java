package com.codegym.c0324h1_spring_boot_2.services;

import com.codegym.c0324h1_spring_boot_2.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Page<Student> findAllByName(String name, Pageable pageable);

    Optional<Student> findById(int id);

    void deleteFindById(Long id);
}