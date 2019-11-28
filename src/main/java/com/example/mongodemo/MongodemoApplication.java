package com.example.mongodemo;

import com.example.mongodemo.domain.Student;
import com.example.mongodemo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodemoApplication implements CommandLineRunner {
	@Autowired
	private StudentRepo studentRepo;

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
