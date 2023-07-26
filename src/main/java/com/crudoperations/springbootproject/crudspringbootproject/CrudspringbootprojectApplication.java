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
		/*Student st=new Student();
		st.setName("Ashlesha");
		st.setAddress("Ktm");
		st.setAge(23);
		Student student1 = studentRepository.save(st);
		System.out.println(student1);*/


	}

/*
	@Autowired*/
	/*private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {

		Student student = new Student();
		student.setId(101);
		student.setName("Ashlesha");
		student.setAddress("Ktm");
		student.setAge(23);
		studentRepository.save(student);


		Student student1 = new Student();
		student.setId(102);
		student.setName("Ashmita");
		student.setAddress("Ktm");
		student.setAge(22);
		studentRepository.save(student1);



	}*/
}
