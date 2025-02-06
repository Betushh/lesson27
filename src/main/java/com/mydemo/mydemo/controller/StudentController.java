package com.mydemo.mydemo.controller;

import com.mydemo.mydemo.Models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/students/getStudent")
    public Student getStudent(){
        return new Student(1,"Steven", "King");
    }

    @GetMapping("/students/getList")
    public List<Student> getList(){
        Student student1 = new Student(1,"Steven", "King");
        Student student2 = new Student(2,"Human2", "holy");
        Student student3 = new Student(3,"HUman3", "hol");
        return List.of(student1,student2,student3);
    }
}
