package com.securitydemo.services;

import com.securitydemo.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> students = new ArrayList<>();
    public StudentService() {
        students.add(new Student("Soumik", 54, 3));
        students.add(new Student("Adidas", 53, 3));
        students.add(new Student("Adi", 50, 2));
        students.add(new Student("Bapi", 64, 4));
    }

    public List<Student> getAllStudents(){
        return this.students;
    }

    public Student getSingleStudent(String name){
        return this.students.stream().filter(student -> student.getName().equals(name)).findAny().orElse(null);
    }

    public Student addSingleStudent(Student student){
        this.students.add(student);
        return student;
    }

    public void deleteSingleStudent(String name){
        Student student = this.students.stream().filter(student1 -> student1.getName().equalsIgnoreCase(name)).findAny().get();
        this.students.remove(student);
    }

}
