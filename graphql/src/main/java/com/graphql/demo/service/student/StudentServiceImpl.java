package com.graphql.demo.service.student;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentServiceImpl implements StudentService {

    private final RestTemplate restTemplate;
    private final String STUDENTS_BY_ID = "http://localhost:8081/api/university/students";

    public StudentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Student getStudentByName(String name) {
        Student student = getStudent(name);
    }

    private Student getStudent(final String name) {


        return null;
    }
}
