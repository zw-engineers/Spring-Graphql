package com.graphql.demo.web;

import com.graphql.demo.domain.Student;
import com.graphql.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class StudentController {

    private static final String STUDENT_URL = "/api/university/students";
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = STUDENT_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
