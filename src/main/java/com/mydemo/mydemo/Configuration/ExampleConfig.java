package com.mydemo.mydemo.Configuration;

import com.mydemo.mydemo.Models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ExampleConfig {

    @Bean(name = "student")
    @Scope("singleton")
    public Student getStudentBean(){
        Student student = new Student();
        student.setId(1);
        student.setName("name");
        student.setSurname("surname");
        return student;
    }
}
