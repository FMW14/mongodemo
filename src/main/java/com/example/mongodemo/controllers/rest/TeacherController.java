package com.example.mongodemo.controllers.rest;

import com.example.mongodemo.domain.Teacher;
import com.example.mongodemo.repos.TeacherRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepo teacherRepo;

    @GetMapping
    public List getAllTeachers() {
        return teacherRepo.findAll();
    }

    @GetMapping("{id}")
    public Teacher getTeacherRById(@PathVariable("id") ObjectId id) {
        return teacherRepo.findBy_id(id);
    }

    @PutMapping("{id}")
    public void modifyTeacherById(@PathVariable("id") ObjectId id, @Valid @RequestBody Teacher teacher) {
        teacher.set_id(id);
        teacherRepo.save(teacher);
    }

    @PostMapping
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher) {
        teacher.set_id(ObjectId.get());
        teacherRepo.save(teacher);
        return teacher;
    }

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable ObjectId id) {
        teacherRepo.delete(teacherRepo.findBy_id(id));
    }

}
