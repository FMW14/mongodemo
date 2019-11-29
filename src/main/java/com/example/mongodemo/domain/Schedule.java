package com.example.mongodemo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shedule")
public class Schedule {
    @Id
    private ObjectId _id;

    @DBRef
    private Teacher teacher;

    @DBRef
    private Subject subject;

    private String group;
    private String room;
    private String startTime;

    public Schedule() {
    }

    public Schedule(Teacher teacher, Subject subject, String group, String room, String startTime) {
        this.teacher = teacher;
        this.subject = subject;
        this.group = group;
        this.room = room;
        this.startTime = startTime;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
