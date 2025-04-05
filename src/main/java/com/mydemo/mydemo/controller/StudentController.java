package com.mydemo.mydemo.controller;

import com.mydemo.mydemo.Models.Student;
import com.mydemo.mydemo.Models.dto.AddStudentRequestDto;
import com.mydemo.mydemo.Models.dto.StudentDto;
import com.mydemo.mydemo.Services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<StudentDto> getList(){
    return studentService.getList();
    }

    @Operation(summary = "Create a new product", description = "Add a new product to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Successfully created the product"),
            @ApiResponse(responseCode = "500", description="Internal server error")
    })
    @GetMapping("/{id}")
    public StudentDto getStudentByID(@PathVariable Integer id) {
        return studentService.getStudentByID(id);
    }


    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentByNameORUniversity(@RequestParam String name) {
        return studentService.getStudentByNameORUniversity(name);
    }

    @GetMapping("/namUni")
    public List<Student> getStudentByNameAndUniversity(@RequestParam String name, @RequestParam String university) {
        return studentService.getStudentByNameAndUniversity(name, university);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto add(@RequestBody AddStudentRequestDto addStudentRequestDto) {
        return studentService.add(addStudentRequestDto);
    }

    @PutMapping
    public Student update(Student student) {
        return studentService.update(student);
    }

    @DeleteMapping
    public void delete(Integer id) {
        studentService.delete(id);
    }
}
