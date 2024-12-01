package com.company.SpringJDBC;

import com.company.SpringJDBC.model.Student;
import com.company.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
	 ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student std = new Student();
		std.setMarks(78);
		std.setName("Rath");
		std.setRollNo(104);
		StudentService stdsevice = context.getBean(StudentService.class);
		stdsevice.addStudent(std);

		List<Student> listOfStud=stdsevice.getAllStudents();
		System.out.println(listOfStud);


	}

}
