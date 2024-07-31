package com.codegym.c0324h1_spring_boot_2.controllers;

import com.codegym.c0324h1_spring_boot_2.models.Student;
import com.codegym.c0324h1_spring_boot_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class RestStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> studentList = studentService.findAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
//        Optional<Student> studentUpdate = studentService.findById(id);
//        if (studentUpdate.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        student.setName(studentUpdate.get().getName());
//        studentService.save(student);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Student  studentUpdate = studentOptional.get();
        studentUpdate.setName(student.getName());
        studentService.save(studentUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        Optional<Student> studentDelete = studentService.findById(id);
        if (studentDelete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Student studentDeleted = studentDelete.get();
        studentService.deleteFindById(studentDeleted.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
