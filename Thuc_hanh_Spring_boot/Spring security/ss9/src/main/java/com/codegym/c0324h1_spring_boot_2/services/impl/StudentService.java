package com.codegym.c0324h1_spring_boot_2.services.impl;

import com.codegym.c0324h1_spring_boot_2.models.Student;
import com.codegym.c0324h1_spring_boot_2.repositories.IStudentRepository;
import com.codegym.c0324h1_spring_boot_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findAllByName(String name, Pageable pageable) {
        return studentRepository.findAllByNameContaining("%"+ name+"%", pageable);
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById((long) id);
    }

    @Override
    public void deleteFindById(Long id) {
        studentRepository.deleteById((long) id);
    }
}
