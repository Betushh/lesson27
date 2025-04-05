package com.mydemo.mydemo.Models.dto;
import com.mydemo.mydemo.Models.Task;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class StudentDto {

    private Integer id;
    private String name;
    private String surname;
    private ProjectDto projectName;
    private List<Task> tasks;

    @Data
    public static class ProjectDto{
        private String name;

    }

    @Data
    public static class TaskDto{
        private String name;

    }
}
