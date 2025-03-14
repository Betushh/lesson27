package com.mydemo.mydemo.Services;

import com.mydemo.mydemo.Models.Student;
import com.mydemo.mydemo.Models.dto.AddStudentRequestDto;
import com.mydemo.mydemo.Models.dto.StudentDto;

import java.util.List;


public interface StudentService {

    List<StudentDto> getList();

    StudentDto getStudentByID(Integer id);

    List<Student>  getStudentByNameORUniversity(String name);

   List<Student>  getStudentByNameAndUniversity(String name, String university);

    StudentDto add(AddStudentRequestDto addStudentRequestDto);

    Student update(Student student);

    void delete(Integer id);


}
