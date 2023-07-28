package com.crudoperations.springbootproject.crudspringbootproject.controller;


import com.crudoperations.springbootproject.crudspringbootproject.repository.StudentRepository;
import com.crudoperations.springbootproject.crudspringbootproject.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.crudoperations.springbootproject.crudspringbootproject.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")  //optional
public class StudentController {


    @Autowired
    private StudentServiceImpl studentService;


    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student student1 = studentService.addStudent(student);
        return new ResponseEntity<Student>(student1, HttpStatus.CREATED);
    }

/*
@DeleteMapping("/removestudent/{id}")
public  ResponseEntity<String> removeStudent(@PathVariable int id){

studentService.removeStudent(id);
return  new ResponseEntity<String>("Remove Sucessfully",HttpStatus.ACCEPTED);
}

*/


    @DeleteMapping("/removestudent/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable int id) {
        // Attempt to remove the student with the given ID
        String responseMessage = studentService.removeStudent(id);

        // Check the response message to determine if the student was deleted successfully
        if (responseMessage.equals("Deleted Successfully.")) {
            // If the student is found and deleted, return a 202 Accepted response
            return new ResponseEntity<>(responseMessage, HttpStatus.ACCEPTED);
        } else {
            // If the student is not found, return a 404 Not Found response
            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/findStudentById/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable Integer id) {

        if (id == null) {
            // Return a 400 Bad Request response if the id is null
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Student> student = studentService.findStudentById(id);

        if (student.isPresent()) {
            // If the student is found, return it with HTTP status 200 OK
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            // If the student is not found, return HTTP status 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/allstudent")
    public ResponseEntity<List<Student>> listofStudent() {
        List<Student> studentList = studentService.getallStudent();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.ACCEPTED);
    }

    /*@GetMapping("/updatestudent/{id}")*/
/*public ResponseEntity<String> updateStudent(@PathVariable int id){



    studentService.updateStudent(id);
    return new ResponseEntity<String>("updated successfully",HttpStatus.ACCEPTED);
}



}*/
    /*public Student updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return student;
    }*/


/*
@PutMapping("/updatestudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        if (updatedStudent != null) {
            // If the student is found and updated, return the updated student object
            return ResponseEntity.ok(updatedStudent);
        } else {
            // If the student is not found, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }
*/




}


