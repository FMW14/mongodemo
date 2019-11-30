package com.example.mongodemo;

import com.example.mongodemo.domain.Schedule;
import com.example.mongodemo.domain.Student;
import com.example.mongodemo.domain.Subject;
import com.example.mongodemo.domain.Teacher;
import com.example.mongodemo.repos.ScheduleRepo;
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
	@Autowired
	private ScheduleRepo scheduleRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepo.deleteAll();
		subjectRepo.deleteAll();
		teacherRepo.deleteAll();

//		groupRepo.deleteAll();

//		groupRepo.save(new Group("N1"));
//		groupRepo.save(new Group("N2"));
		Student st1 = new Student("Ivan", "Ivanov", "G1");
		Student st2 = new Student("Ivan", "Petrov", "G2");
		Student st3 = new Student("Petr", "Alexandrov", "G2");
		Subject subj1 = new Subject("subj1");
		Subject subj2 = new Subject("subj2");
		Teacher teacher1 = new Teacher("Name1", "Lastname1");
		Teacher teacher2 = new Teacher("Name2", "Lastname2");

		studentRepo.save(st1);
		studentRepo.save(st2);
		studentRepo.save(st3);

		subjectRepo.save(subj1);
		subjectRepo.save(subj2);

		teacherRepo.save(teacher1);
		teacherRepo.save(teacher2);

		Schedule schedule1 = new Schedule(teacher1, subj1, "G1", "123", "9:00" );
		scheduleRepo.save(schedule1);

//		scheduleRepo.save(new Schedule())

//		System.out.println(studentRepo.findByName("Ivan").get_id().toString());
//		Student s1 = new Student();
//		s1 = studentRepo.findByFirstName("Ivan");
//		System.out.println(s1.getGroup());

		System.out.println("-------------------------------");
		for (Student student : studentRepo.findAll()) {
			System.out.println(student.getName());
		}
		System.out.println();

		System.out.println("-------------------------------");
		for (Student student : studentRepo.findByName("Ivan")) {
			System.out.println(student.getName());
		}
		System.out.println();


	}

}
