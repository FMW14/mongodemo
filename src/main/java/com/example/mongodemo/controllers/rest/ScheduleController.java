package com.example.mongodemo.controllers.rest;

import com.example.mongodemo.domain.Schedule;
import com.example.mongodemo.repos.ScheduleRepo;
import com.example.mongodemo.repos.SubjectRepo;
import com.example.mongodemo.repos.TeacherRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private TeacherRepo teacherRepo;

    @GetMapping
    public List getFullSchedule() {
        return scheduleRepo.findAll();
    }

    @GetMapping("{id}")
    public Schedule getStringById(@PathVariable("id") ObjectId id) {
        return scheduleRepo.findBy_id(id);
    }

    @PutMapping("{id}")
    public void modifyStringById(@PathVariable("id") ObjectId id, @Valid @RequestBody Schedule schedule) {
        schedule.set_id(id);
        scheduleRepo.save(schedule);
    }

    @PostMapping
    public Schedule addString(@Valid @RequestBody Schedule schedule) {
        schedule.set_id(ObjectId.get());
        scheduleRepo.save(schedule);
        return schedule;
    }

    @DeleteMapping("{id}")
    public void deleteString(@PathVariable ObjectId id) {
        scheduleRepo.delete(scheduleRepo.findBy_id(id));
    }

    @GetMapping("/findbygroup/{group}")
    public List getScheduleByGroup(@PathVariable String group) {
        return scheduleRepo.findByGroup(group);
    }

    @GetMapping("/findbyroom/{room}")
    public List getScheduleByRoom(@PathVariable String room) {
        return scheduleRepo.findByGroup(room);
    }

    @GetMapping("/findbyteacher/{id}")
    public List getScheduleByTeacher(@PathVariable ObjectId id) {
        return scheduleRepo.findByTeacher(teacherRepo.findBy_id(id));
    }

    @GetMapping("/findbysubj/{id}")
    public List getScheduleBySubj(@PathVariable ObjectId id) {
        return scheduleRepo.findBySubject(subjectRepo.findBy_id(id));
    }
}
