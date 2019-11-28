package com.example.mongodemo.repos;

import com.example.mongodemo.domain.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepo extends MongoRepository <Student, String > {

    /**
     * Этот метод извлекает подробности об участнике лиги справедливости, связанным с .
     * переданным именем.
     *
     * @param superHeroName
     *            имя участника лиги справедливости для поиска и извлечения.
     * @return возвращает инстанс {@link Student} с подробностями
     *         об участнике.
     */
//    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    Student findByName(final String studentName);

    Student findBy_id(ObjectId id);

//     List<Student> findAll();
}