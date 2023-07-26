package com.crudoperations.springbootproject.crudspringbootproject.entity;


import jakarta.persistence.*;


 /*an entity class that represents a table in the database. This class should be annotated with @Entity and
        should have a primary key field annotated with @Id.*/
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment id

    private int id;

    private String name;

    private String address;


    private int age;



    public Student(int id, String name, String address, int age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public Student(){

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
