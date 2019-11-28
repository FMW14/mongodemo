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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllTeachers() {
        return teacherRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Teacher getTeacherRById(@PathVariable("id") ObjectId id) {
        return teacherRepo.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyTeacherById(@PathVariable("id") ObjectId id, @Valid @RequestBody Teacher teacher) {
        teacher.set_id(id);
        teacherRepo.save(teacher);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher) {
        teacher.set_id(ObjectId.get());
        teacherRepo.save(teacher);
        return teacher;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable ObjectId id) {
        teacherRepo.delete(teacherRepo.findBy_id(id));
    }

}
