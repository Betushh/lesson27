package com.mydemo.mydemo.mapper;

import com.mydemo.mydemo.Models.Student;
import com.mydemo.mydemo.Models.dto.AddStudentRequestDto;
import com.mydemo.mydemo.Models.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    @Mapping(source = "project", target = "projectName")
    @Mapping(source = "student", target = "fullName", qualifiedByName = "mapFullName")
    StudentDto toStudentDto(Student student);

    @Named("mapFullName")
    default String mapFullName(Student student){
        return student.getName() +" "+ student.getSurname();
    }

//    @Mapping(source = "lastName", target = "surname")
    Student toStudent(AddStudentRequestDto addStudentRequestDto);

    @Mapping(source = "project", target = "projectName")
    @Mapping(source = "student", target = "fullName", qualifiedByName = "mapFullName")
    List<StudentDto> toStudentDtoList(List<Student> studentList);

}
