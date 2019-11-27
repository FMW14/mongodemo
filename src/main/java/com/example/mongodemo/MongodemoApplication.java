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
		studentRepo.save(new Student("Ivan", "Ivanovich"));
		studentRepo.save(new Student("Zalup", "Zalupovich"));

		System.out.println("-------------------------------");
		for (Student student : studentRepo.findAll()) {
			System.out.println(student.getFirstName());
		}
		System.out.println();


	}

}
