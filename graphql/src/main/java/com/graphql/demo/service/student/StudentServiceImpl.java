package com.graphql.demo.service.student;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final RestTemplate restTemplate;

    public StudentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<StudentDto> getStudentByName() {
        List<Student> students = getStudent();
        return this.convertToDto(students);
    }

    private List<StudentDto> convertToDto(List<Student> students) {
        return students
                .stream()
                .map(student -> new StudentDto(student.getName(), student.getSurname()))
                .collect(Collectors.toList());
    }

    private List<Student> getStudent() {
        final String url = "http://localhost:8081/api/university/students";

        ParameterizedTypeReference<List<Student>> studentRef = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<Student>> response = this.restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, studentRef);

        if (response.getStatusCode().value() == 200) {
            return response.getBody();
        } else {
            throw new RuntimeException("Got an unexpected response from University Service");
        }
    }
}
