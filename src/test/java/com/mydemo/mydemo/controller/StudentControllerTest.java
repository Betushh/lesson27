//package com.mydemo.mydemo.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mydemo.mydemo.Models.dto.AddStudentRequestDto;
//import com.mydemo.mydemo.Models.dto.StudentDto;
//import com.mydemo.mydemo.Services.StudentService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import java.util.List;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//class StudentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private StudentService studentService;
//
//    private StudentDto studentDto;
//    private StudentDto studentDto1;
//    private AddStudentRequestDto addStudentRequestDto;
//
//    @BeforeEach
//    void setUp() {
//        studentDto = new StudentDto();
//        studentDto.setId(2);
//        studentDto.setName("Narmin");
//
//        studentDto1 = new StudentDto();
//        studentDto1.setId(3);
//        studentDto1.setName("Human");
//
//        addStudentRequestDto = new AddStudentRequestDto();
//        addStudentRequestDto.setId(2);
//        addStudentRequestDto.setName("Narmin");
//    }
//
//    @AfterEach
//    void tearDown() {
//        studentService = null;
//        studentDto = null;
//        addStudentRequestDto = null;
//        studentDto1 = null;
//    }
//
//    @TestConfiguration
//    static class MockConfig {
//        @Bean
//        public StudentService studentService() {
//            return mock(StudentService.class);
//        }
//    }
//
//    @Test
//    void givenAllThenReturnThenOk() throws Exception {
//        List<StudentDto> studentDtos = List.of(studentDto,studentDto1);
//
//        when(studentService.getList()).thenReturn(studentDtos);
//
//        mockMvc.perform(get("/students",1)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2))
//                .andExpect(jsonPath("$[0].id").value(2))
//                .andExpect(jsonPath("$[0].name").value("Narmin"))
//                .andExpect(jsonPath("$[1].id").value(3))
//                .andExpect(jsonPath("$[1].name").value("Human"))
//                .andDo(print());
//
//        verify(studentService, times(1)).getList();
//    }
//
//    @Test
//    void givenIdThenReturnThenOk() throws Exception {
//
//        when(studentService.getStudentByID(2)).thenReturn(studentDto);
//
//        mockMvc.perform(get("/students/{id}", 2)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(2))
//                .andExpect(jsonPath("$.name").value("Narmin"))
//                .andDo(print());
//
//        verify(studentService, times(1)).getStudentByID(2);
//    }
//
//    @Test
//    void givenStudentThenSaveThenOk() throws Exception {
//
//        when(studentService.add(addStudentRequestDto)).thenReturn(studentDto);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        mockMvc.perform(post("/students")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(studentDto)))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value(2))
//                .andExpect(jsonPath("$.name").value("Narmin"))
//                .andDo(print());
//
//        verify(studentService, times(1)).add(addStudentRequestDto);
//    }
//
//}