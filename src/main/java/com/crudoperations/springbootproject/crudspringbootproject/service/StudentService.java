package com.crudoperations.springbootproject.crudspringbootproject.service;

import com.crudoperations.springbootproject.crudspringbootproject.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {


    public Student addStudent(Student student);

    public String removeStudent(int id);

    public Optional<Student> findStudentById(int id);

    public List<Student> getallStudent();





}
