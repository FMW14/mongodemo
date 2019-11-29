package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Schedule;
import com.example.mongodemo.domain.Subject;
import com.example.mongodemo.domain.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ScheduleRepo extends MongoRepository <Schedule, String > {
    Schedule findBy_id(ObjectId id);
    List<Schedule> findByGroup(String group);
    List<Schedule> findByTeacher(Teacher teacher);
    List<Schedule> findBySubject(Subject subject);
    List<Schedule> findByStartTime(String startTime);
    List<Schedule> findByRoom(String room);

}