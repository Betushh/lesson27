package com.mydemo.mydemo.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.TLSClientHelloExtractor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "students")
//@NamedEntityGraph(name = "studentTasks", attributeNodes = @NamedAttributeNode("task"))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String university;
    private Integer salary;
    private Integer status;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Project project;


    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> task;


    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)// ada soz dedi niye?
    private List<Lesson> lessons;
}

