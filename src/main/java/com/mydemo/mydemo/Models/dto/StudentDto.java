package com.mydemo.mydemo.Models.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentDto {

    private String fullName;
    private ProjectDto projectName;
//    private List<Task> tasks;

    @Data
    public static class ProjectDto{
        private String name;

    }

//    @Data
//    public static class TaskDto{
//        private String name;
//
//    }
}
