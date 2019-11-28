package com.example.mongodemo.controllers.rest;

import com.example.mongodemo.domain.Student;
import com.example.mongodemo.domain.Teacher;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllStudents() {
        return studentRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") ObjectId id) {
        return studentRepo.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyStudentById(@PathVariable("id") ObjectId id, @Valid @RequestBody Student student) {
        student.set_id(id);
        studentRepo.save(student);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Student addStudent(@Valid @RequestBody Student student) {
        student.set_id(ObjectId.get());
        studentRepo.save(student);
        return student;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable ObjectId id) {
        studentRepo.delete(studentRepo.findBy_id(id));
    }

}
