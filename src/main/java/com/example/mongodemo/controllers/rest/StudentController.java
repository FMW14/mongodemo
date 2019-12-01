package com.example.mongodemo.controllers.rest;

import com.example.mongodemo.domain.Student;
import com.example.mongodemo.repos.StudentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public List getAllStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id") ObjectId id) {
        return studentRepo.findBy_id(id);
    }

    @PutMapping("{id}")
    public void modifyStudentById(@PathVariable("id") ObjectId id, @Valid @RequestBody Student student) {
        student.set_id(id);
        studentRepo.save(student);
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        student.set_id(ObjectId.get());
        studentRepo.save(student);
        return student;
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable ObjectId id) {
        studentRepo.delete(studentRepo.findBy_id(id));
    }

}
