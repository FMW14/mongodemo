package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Subject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface SubjectRepo extends MongoRepository <Subject, String > {
    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    List<Subject> findByName(final String subjName);

    Subject findBy_id(ObjectId id);

//     List<Student> findAll();
}