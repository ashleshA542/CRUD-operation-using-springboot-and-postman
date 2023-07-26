package com.crudoperations.springbootproject.crudspringbootproject.repository;


import com.crudoperations.springbootproject.crudspringbootproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>  //JpaRepository<Student, Integer> is a generic type so kun typeko data handle garne ho tyo lekhne and tesko ko id kun type ko ho
{



}
