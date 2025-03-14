package com.mydemo.mydemo.Configuration;

import com.mydemo.mydemo.Models.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
public class ExampleConfig {
//
//    @Bean(name = "student")
//    @Scope("singleton")
//    public Student getStudentBean(){
//        Student student = new Student();
//        student.setId(1);
//        student.setName("name");
//        student.setSurname("surname");
//        return student;
//    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .defaultCookie ("cookieKey", "cookieValue")
                .defaultHeader (HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8081"))
                .build();
    }
}
