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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllSubjects() {
        return subjectRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subject getSubjectById(@PathVariable("id") ObjectId id) {
        return subjectRepo.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifySubjectById(@PathVariable("id") ObjectId id, @Valid @RequestBody Subject subject) {
        subject.set_id(id);
        subjectRepo.save(subject);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Subject addSubject(@Valid @RequestBody Subject subject) {
        subject.set_id(ObjectId.get());
        subjectRepo.save(subject);
        return subject;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubject(@PathVariable ObjectId id) {
        subjectRepo.delete(subjectRepo.findBy_id(id));
    }

}
