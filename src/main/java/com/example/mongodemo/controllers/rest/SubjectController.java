package com.example.mongodemo.controllers.rest;

import com.example.mongodemo.domain.Subject;
import com.example.mongodemo.repos.SubjectRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectRepo subjectRepo;

    @GetMapping
    public List getAllSubjects() {
        return subjectRepo.findAll();
    }

    @GetMapping("{id}")
    public Subject getSubjectById(@PathVariable("id") ObjectId id) {
        return subjectRepo.findBy_id(id);
    }

    @PutMapping("{id}")
    public void modifySubjectById(@PathVariable("id") ObjectId id, @Valid @RequestBody Subject subject) {
        subject.set_id(id);
        subjectRepo.save(subject);
    }

    @PostMapping
    public Subject addSubject(@Valid @RequestBody Subject subject) {
        subject.set_id(ObjectId.get());
        subjectRepo.save(subject);
        return subject;
    }

    @DeleteMapping("{id}")
    public void deleteSubject(@PathVariable ObjectId id) {
        subjectRepo.delete(subjectRepo.findBy_id(id));
    }

}
