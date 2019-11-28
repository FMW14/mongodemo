package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Subject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface SubjectRepo extends MongoRepository <Subject, String > {
    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    Subject findByName(final String studentName);

    Subject findBy_id(ObjectId id);

//     List<Student> findAll();
}