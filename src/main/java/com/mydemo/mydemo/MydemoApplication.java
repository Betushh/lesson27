package com.mydemo.mydemo;

import com.mydemo.mydemo.Configuration.ExampleConfig;
import com.mydemo.mydemo.Models.Human;
import com.mydemo.mydemo.Models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MydemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExampleConfig.class);
		Human human = new Human(1, "Human", "human surname");

//
//		Student student = (Student) applicationContext.getBean("student");
//		System.out.println(student);


//		ApplicationContext applicationContextm = new ClassPathXmlApplicationContext("Beans.xml");
//		Student student = (Student) applicationContextm.getBean("student");
//		Student student2 = (Student) applicationContextm.getBean("student");
//		student2.setId(3);
//		System.out.println(student);
//		System.out.println(student2);
	}
}
