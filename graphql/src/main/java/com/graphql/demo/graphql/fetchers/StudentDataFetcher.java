package com.graphql.demo.graphql.fetchers;

import com.graphql.demo.service.student.StudentService;
import org.springframework.stereotype.Component;

@Component
public class StudentDataFetcher {

    private final StudentService studentService;

    public StudentDataFetcher(StudentService studentService) {
        this.studentService = studentService;
    }
}
