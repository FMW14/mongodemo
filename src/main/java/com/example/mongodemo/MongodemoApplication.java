package com.example.mongodemo;

import com.example.mongodemo.domain.Student;
import com.example.mongodemo.domain.Subject;
import com.example.mongodemo.domain.Teacher;
import com.example.mongodemo.repos.StudentRepo;
import com.example.mongodemo.repos.SubjectRepo;
import com.example.mongodemo.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodemoApplication implements CommandLineRunner {
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private TeacherRepo teacherRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepo.deleteAll();
//		groupRepo.deleteAll();

//		groupRepo.save(new Group("N1"));
//		groupRepo.save(new Group("N2"));

		studentRepo.save(new Student("Ivan", "Ivanovich", "G1"));
		studentRepo.save(new Student("Zalup", "Zalupovich"));

		subjectRepo.save(new Subject("subj1"));
		subjectRepo.save(new Subject("subj2"));

		teacherRepo.save(new Teacher("Name1", "Lastname1"));
		teacherRepo.save(new Teacher("Name2", "Lastname2"));

		System.out.println(studentRepo.findByName("Ivan").get_id().toString());
//		Student s1 = new Student();
//		s1 = studentRepo.findByFirstName("Ivan");
//		System.out.println(s1.getGroup());

		System.out.println("-------------------------------");
		for (Student student : studentRepo.findAll()) {
			System.out.println(student.getName());
		}
		System.out.println();


	}

}
