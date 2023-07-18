package com.securitydemo.controllers;

import com.securitydemo.models.Student;
import com.securitydemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping(path = "/")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping(path = "/{name}")
    public Student getSingleStudent(@PathVariable(name = "name") String name){
        return this.service.getSingleStudent(name);
    }

    @PostMapping(path = "/")
    public Student addSingleStudent(@RequestBody Student student){
        this.service.addSingleStudent(student);
        return student;
    }

    @DeleteMapping(path = "/{name}")
    public void deleteSingleStudent(@PathVariable(name = "name") String name){
        this.service.deleteSingleStudent(name);
    }
}
