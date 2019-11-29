package com.example.mongodemo.controllers.rest;

import com.example.mongodemo.domain.Schedule;
import com.example.mongodemo.domain.Teacher;
import com.example.mongodemo.repos.ScheduleRepo;
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

    @RequestMapping(value = "/{group}", method = RequestMethod.GET)
    public List getScheduleByGroup(@PathVariable String group) {
        return scheduleRepo.findByGroup(group);
    }

    @RequestMapping(value = "/{teacher}", method = RequestMethod.GET)
    public List getScheduleByGroup(@PathVariable Teacher teacher) {
        return scheduleRepo.findByTeacher(teacher);
    }

}
