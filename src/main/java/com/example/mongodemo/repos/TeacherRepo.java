package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface TeacherRepo extends MongoRepository <Teacher, String > {
    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    Teacher findByName(final String teacherName);

    Teacher findBy_id(ObjectId id);
}