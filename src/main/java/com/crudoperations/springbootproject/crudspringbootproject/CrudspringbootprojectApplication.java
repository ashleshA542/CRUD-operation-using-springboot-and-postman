package com.crudoperations.springbootproject.crudspringbootproject;

import com.crudoperations.springbootproject.crudspringbootproject.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class CrudspringbootprojectApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		ApplicationContext  context=SpringApplication.run(CrudspringbootprojectApplication.class, args);
		StudentRepository studentRepository= context.getBean(StudentRepository.class);


	}

}
