package com.crudoperations.springbootproject.crudspringbootproject.service;

import com.crudoperations.springbootproject.crudspringbootproject.entity.Student;
import com.crudoperations.springbootproject.crudspringbootproject.exception.ResourceNotFoundException;
import com.crudoperations.springbootproject.crudspringbootproject.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;


@Service //business logic lekhne vanera indicate garxa
public class StudentServiceImpl implements StudentService {


    @Autowired

    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
        Student std = studentRepository.save(student);
        return std;
    }


    public String removeStudent(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);


        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return "Deleted Successfully.";
        } else {
            return "Student not found";
        }

    }


    @Override
    public Optional<Student> findStudentById(int id) {


        Optional<Student> std = studentRepository.findById(id);

        return std;


    }


    @Override
    public List<Student> getallStudent() {
        List<Student> std = studentRepository.findAll();
        return std;
    }


    @Override
    public Student updateStudent(int id, Student student) {
        {
            Student existingStudent = studentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Student with ID " + id + " not found."));

            BeanUtils.copyProperties(student, existingStudent);

           /* existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setId(student.getId());
*/

            return studentRepository.save(existingStudent);
        }
    }
}




















