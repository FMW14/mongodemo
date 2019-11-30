package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface StudentRepo extends MongoRepository <Student, String > {

    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    List<Student> findByName(String studentName);
    List<Student> findBySurname(String surname);

    Student findBy_id(ObjectId id);
}