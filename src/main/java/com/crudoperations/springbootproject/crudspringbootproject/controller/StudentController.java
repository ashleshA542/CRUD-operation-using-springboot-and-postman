package com.crudoperations.springbootproject.crudspringbootproject.controller;


import com.crudoperations.springbootproject.crudspringbootproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.crudoperations.springbootproject.crudspringbootproject.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    //create new record in database
    @PostMapping("/savestudent")/* annotation that maps the method to handle HTTP POST requests with the specified endpoint "/savestudent".*/
    public Student saveData(@RequestBody Student student)/*When a POST request is made to this endpoint,
    the method saveData() will be executed.and this method takes Student object as input in request body
    @RequestBody annotation tells Spring to deserialize the incoming JSON data from the request body into a Student object.*/ {

        studentRepository.save(student); /*save() method is used to save or update the student object into the database.*/
        return student;
    }

    //fetch all the data from database
    @GetMapping("/getallstudentindatabase")
    public List<Student> getAll() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;

    }

    /*@GetMapping("/getstudent/{id}")
    public Student getstudentdata(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(id);
        Student student1 = student.get();
        return student1;


    }
*/


    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Student> getstudentdata(@PathVariable Integer id) {
        if (id == null) {
            // Handle the case when id is null, return a bad request response
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            Student existingStudent = student.get();
            // Return the existingStudent
            return ResponseEntity.ok(existingStudent);
        } else {
            // Handle the case when student with the specified id does not exist
            // Return a not found response
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatestudentdatabase")
    public Student updateStudent(@RequestBody Student student){
        studentRepository.save(student);
        return student;
}




//to delete particular record from database
    @DeleteMapping("/deletestudent/{id}")
    public String deletestudent(@PathVariable int id){
        Student student =studentRepository.findById(id).get();
        if(student!=null)
            studentRepository.delete(student);
        return "Deleted Successfully.";
    }





}
