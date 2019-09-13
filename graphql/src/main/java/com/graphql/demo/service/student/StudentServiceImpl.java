package com.graphql.demo.service.student;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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

    @Override
    public StudentDto getStudentByName(String name) {
        return getStudent()
                .stream()
                .filter(student -> name.equals(student.getName()))
                .map(this::convertStudentToDTO)
                .findFirst()
                .orElse(new StudentDto());
    }

    private List<StudentDto> convertToDto(List<Student> students) {
        return students
                .stream()
                .map(convertStudentToDTO())
                .collect(Collectors.toList());
    }

    private StudentDto convertStudentToDTO(Student student) {
        return Optional.ofNullable(student)
                .stream()
                .map(convertStudentToDTO())
                .findFirst().orElse(new StudentDto());

    }

    private Function<Student, StudentDto> convertStudentToDTO() {
        return student -> new StudentDto(student.getName(), student.getSurname(), student.getDegree(), student.getTutor());
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
