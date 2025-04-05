package com.mydemo.mydemo.Services.serviceImp;

import com.mydemo.mydemo.Models.Student;
import com.mydemo.mydemo.Models.dto.AddStudentRequestDto;
import com.mydemo.mydemo.Models.dto.StudentDto;
import com.mydemo.mydemo.Services.StudentService;
import com.mydemo.mydemo.mapper.StudentMapper;
import com.mydemo.mydemo.repositories.StudentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Data
public class StudentServiceImp implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;
//    private  ModelMapper modelMapper;

    @Override
    public List<StudentDto> getList() {
        return studentMapper.toStudentDtoList(repository.findAll());
    }

    @Override
    public StudentDto getStudentByID(Integer id) {
//        return studentMapper.toStudentDto(repository.findById(id).orElseThrow(RuntimeException::new));
        Student student = repository.findById(id).orElseThrow(NullPointerException::new);
//        return modelMapper.map(student, StudentDto.class);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public List<Student> getStudentByNameORUniversity(String name) {
        return repository.findStudentByNameOrUniversity(name);
    }

    @Override
    public List<Student> getStudentByNameAndUniversity(String name, String university) {
        return repository.findStudentByNameAndUniversity(name, university);
    }

    @Override
    public StudentDto add(AddStudentRequestDto addStudentRequestDto) {
        var student = studentMapper.toStudent(addStudentRequestDto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentDto(savedStudent);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
