package com.graphql.demo.graphql.fetchers;

import com.graphql.demo.service.student.StudentService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public class StudentDataFetcher {

    private final StudentService studentService;

    public StudentDataFetcher(StudentService studentService) {
        this.studentService = studentService;
    }

    public DataFetcher getAllStudents() {

        return dataFetchingEnvironment -> {
            return this.studentService.getStudentByName();
        };
    }
}
