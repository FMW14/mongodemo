package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface TeacherRepo extends MongoRepository <Teacher, String > {
    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    List<Teacher> findByName(String teacherName);
    List<Teacher> findBySurname(String teacherSurname);

    Teacher findBy_id(ObjectId id);
}