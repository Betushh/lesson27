//package com.mydemo.mydemo.serviceImp;
//
//import com.mydemo.mydemo.Models.Student;
//import com.mydemo.mydemo.Models.dto.AddStudentRequestDto;
//import com.mydemo.mydemo.Models.dto.StudentDto;
//import com.mydemo.mydemo.mapper.StudentMapper;
//import com.mydemo.mydemo.repositories.StudentRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class StudentServiceImpTest {
//
//    @Mock
//    private StudentRepository studentRepository;
//
//    @Mock
//    private StudentMapper mapper;
//
//    @InjectMocks
//    private StudentServiceImp studentServiceImp;
//
//    private Student student;
//    private Student student1;
//    private StudentDto studentDto;
//    private StudentDto studentDto1;
//    private AddStudentRequestDto addStudentRequestDto;
//
//
//    @BeforeEach
//    void setUp() {
//        student = new Student();
//        student.setId(2);
//        student.setName("name");
//        student.setSurname("surname");
//
//        student1 = new Student();
//        student1.setId(2);
//        student1.setName("name1");
//        student1.setSurname("surname1");
//
//        studentDto = new StudentDto();
//        studentDto.setId(2);
//        studentDto.setName("name");
//
//        studentDto1 = new StudentDto();
//        studentDto1.setId(2);
//        studentDto1.setName("name1");
//
//
//    }
//
//    @AfterEach
//    void tearDown() {
//        studentServiceImp = null;
//        student = null;
//        student1 = null;
//        studentDto = null;
//        studentDto1 = null;
//    }
//
//    @Test
//    void givenIdThenReturnThenOk() {
//        //Arrange
//        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
//        when(mapper.toStudentDto(student)).thenReturn(studentDto);
//
//        //Act
//        StudentDto studentDto1 = studentServiceImp.getStudentByID(2);
//        //Assert
//        assertThat(studentDto1.getName()).isEqualTo("name");
//        assertNotNull(studentServiceImp);
//        assertNotNull(studentRepository);
//        assertNotNull(mapper);
//        //Verify
//        verify(studentRepository, times(1)).findById(2);
//
//    }
//
//    @Test
//    void givenCustomerThenSaveThenOk(){
//
//        //arrange
//        when(mapper.toStudent(addStudentRequestDto)).thenReturn(student);
//        when(studentRepository.save(any())).thenReturn(student);
//        when(mapper.toStudentDto(student)).thenReturn(studentDto);
//
//        //Act
//        StudentDto studentDto1 = studentServiceImp.add(addStudentRequestDto);
//
//        //Assert
//        assertThat(studentDto1.getName()).isEqualTo( "name");
//
//        //verify
//        verify(mapper, times(1)).toStudent(addStudentRequestDto);
//        verify(studentRepository, times(1)).save(any());
//        verify(mapper, times(1)).toStudentDto(student);
//    }
//
//    @Test
//    void givenAllThenReturnThenOk() {
//        List<Student> studentList = List.of(student,student1);
//        List<StudentDto> studentDtos = List.of(studentDto,studentDto1);
//
//        when(studentRepository.findAll()).thenReturn(studentList);
//        when(mapper.toStudentDtoList(studentList)).thenReturn(studentDtos);
//
//
//        List<StudentDto> studentDtos1 = studentServiceImp.getList();
//
//        assertThat(studentDtos1.getLast().getName()).isEqualTo("name1");
//
//        verify(studentRepository,times(1)).findAll();
//        verify(mapper, times(1)).toStudentDtoList(studentList);
//    }
//
//    @Test
//    void deleteStudentThenOk(){
//        Integer id = 1;
//        studentServiceImp.delete(id);
//        verify(studentRepository, times(1)).deleteById(id);
//    }
//
//}