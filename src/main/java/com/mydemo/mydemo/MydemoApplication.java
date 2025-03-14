package com.mydemo.mydemo;

import com.mydemo.mydemo.Models.Student;
import com.mydemo.mydemo.repositories.StudentRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;


@RequiredArgsConstructor
@Slf4j
@SpringBootApplication
@EnableFeignClients(basePackages = "com.mydemo.mydemo.client")
//@Transactional
public class MydemoApplication implements CommandLineRunner {

    private final StudentRepository repository;
    //	private final EntityManager entityManager;
//	private final ProjectRepository projectRepository;
//	private final LessonRepository lessonRepository;
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public static void main(String[] args) {
        SpringApplication.run(MydemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


//
//		Student student = repository.findById(1).get();
//		log.info("student = {}", student);

//		Student student = new Student();
//		student.setName("Chris4");
//		student.setSurname("Evans");
//		student1.setUniversity("ADA");
//		student1.setSalary(1200);
////
////
//		Lesson lesson1 = new Lesson();
//		lesson1.setName("It");
//
//
//		Lesson lesson2 = new Lesson();
//		lesson2.setName("Finance");
//
//		student1.setLessons(List.of(lesson1,lesson2));
//
//		repository.save(student1);



		/*

		Student student = new Student();
		student.setName("someone2");
		student.setSurname("someone son1");
		student.setUniversity("bdu");
		student.setSalary(200);

		Project project = new Project();
		project.setName("demo");
		project.setStudent(student);

		student.setProjects(project);


		List<Task> tasks = new ArrayList<>();
		Task task1 = new Task();
		task1.setName("no11");
		task1.setStudent(student);

		Task task2 = new Task();
		task2.setName("no2");
		task2.setStudent(student);

		student.setTask(List.of(task1,task2));

		repository.save(student);

		 */


//
//		Student student1 = repository.findById(1).get();
//		System.out.println(student1);

//		entityManager.getTransaction().begin();
//		entityManager.persist(student);
//		entityManager.getTransaction().commit();

/*
		List<Student> students = repository.findByBetweenId(1, 2);

		for(Student student: students){
			log.info("student -> {}", student);
		}

		List<Student> studentsJpql = repository.findByBetweenIdJpql(1,2);

		for(Student student: studentsJpql){
			log.info("student -> {}", student);
		}



//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExampleConfig.class);
//		Student student = (Student) applicationContext.getBean("student");
//		System.out.println(student);


//		ApplicationContext applicationContextm = new ClassPathXmlApplicationContext("Beans.xml");
//		Student student = (Student) applicationContextm.getBean("student");
//		Student student2 = (Student) applicationContextm.getBean("student");
//		student2.setId(3);
//		System.out.println(student);
//		System.out.println(student2);

 */

//		sendEmail();
//		sendEmailWithHtmlTemplate();
//		sendEmailWithAttachment();

    }

    private void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("narminabaszada@gmail.com");
        msg.setFrom("betushuseyn654@gmail.com");
        msg.setSubject("Spring email");
        msg.setText("Hello Nerminnnnn");

        javaMailSender.send(msg);
        log.info("our email has been sent");
    }

    public void sendEmailWithHtmlTemplate() {
        Context context = new Context();
        context.setVariable("message", "It is test html template");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo("nurumzade2005@gmail.com");
            helper.setFrom("betushuseyn654@gmail.com");
            helper.setSubject("Hello Nerminnnnn");
            String htmlContent = templateEngine.process("email-templates", context);
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
            log.info("Email successfully sent with template");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEmailWithAttachment() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("narminabaszada@gmail.com");
        helper.setFrom("betushuseyn654@gmail.com");
        helper.setSubject("Hello Nerminnnnn");
        helper.setText("special message");

        helper.addAttachment("For Narmin", new File("src/main/java/com/mydemo/mydemo/demo.txt"));
        javaMailSender.send(msg);
        log.info("Email successfully sent with template");
    }

//	public void getTransaction(){
//
//		entityManager.getTransaction().begin();
//		try{
//			Student student1 = repository.findById(1).get();
//			student1.setSurname("searching");
//
//			if(true){
//				throw new RuntimeException();
//			}
//
//			Student student = new Student();
//			student.setId(1);
//			student.setName("someone");
//			student.setSurname("dunno");
//			student.setSalary(233);
//			student.setUniversity("bdu");
//
//			repository.save(student);
//			entityManager.getTransaction().commit();
//
//		} catch (RuntimeException e) {
//			entityManager.getTransaction().rollback();
//		}
//	}

}

