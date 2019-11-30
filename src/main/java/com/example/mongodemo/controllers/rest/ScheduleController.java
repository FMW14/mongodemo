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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getFullSchedule() {
        return scheduleRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Schedule getStringById(@PathVariable("id") ObjectId id) {
        return scheduleRepo.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyStringById(@PathVariable("id") ObjectId id, @Valid @RequestBody Schedule schedule) {
        schedule.set_id(id);
        scheduleRepo.save(schedule);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Schedule addString(@Valid @RequestBody Schedule schedule) {
        schedule.set_id(ObjectId.get());
        scheduleRepo.save(schedule);
        return schedule;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteString(@PathVariable ObjectId id) {
        scheduleRepo.delete(scheduleRepo.findBy_id(id));
    }

    @RequestMapping(value = "/findbygroup/{group}", method = RequestMethod.GET)
    public List getScheduleByGroup(@PathVariable String group) {
        return scheduleRepo.findByGroup(group);
    }

    @RequestMapping(value = "/findbyteacher/{id}", method = RequestMethod.GET)
    public List getScheduleByTeacher(@PathVariable ObjectId id) {
        return scheduleRepo.findByTeacher(teacherRepo.findBy_id(id));
    }

    @RequestMapping(value = "/findbysubj/{id}", method = RequestMethod.GET)
    public List getScheduleBySubj(@PathVariable ObjectId id) {
        return scheduleRepo.findBySubject(subjectRepo.findBy_id(id));
    }
}
