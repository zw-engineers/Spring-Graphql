package com.graphql.service.student;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Service
public class StudentServiceImpl implements StudentService {

    private final RestTemplate restTemplate;

    public StudentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = getStudents();
        return this.convertListOfStudentsToDTO(students);
    }

    @Override
    public StudentDto getStudentByName(String name) {
        return getAllStudents()
                .stream()
                .filter(getStudentDtoPredicate(name))
                .findFirst()
                .orElse(new StudentDto());
    }

    @Override
    public StudentDto getStudentByDegree(String degree) {
        return getAllStudents()
                .stream()
                .filter(getStudentByDegreePredicate(degree))
                .findFirst()
                .orElse(new StudentDto());
    }

    @Override
    public StudentDto getStudentByTutor(String tutor) {
        return getAllStudents()
                .stream()
                .filter(isStudentTutorNameOrSurname(tutor))
                .findFirst()
                .orElse(new StudentDto());
    }

    private Predicate<StudentDto> getStudentDtoPredicate(String name) {
        return student -> name.equals(student.getName());
    }

    private Predicate<StudentDto> getStudentByDegreePredicate(String degree) {
        return student -> degree.equals(student.getDegree().getDegree());
    }

    private Predicate<StudentDto> isStudentTutorNameOrSurname(String tutor) {
        return student -> tutor.equals(student.getTutor().getName()) || tutor.equals(student.getTutor().getSurname());
    }

    private List<StudentDto> convertListOfStudentsToDTO(List<Student> students) {
        return students
                .stream()
                .map(this::convertStudentToDTO)
                .collect(Collectors.toList());
    }

    private StudentDto convertStudentToDTO(Student student) {
        return new StudentDto(student.getName(), student.getSurname(), student.getDegree(), student.getTutor());
    }

    private List<Student> getStudents() {
        final String url = "http://localhost:8081/api/university/students";

        ParameterizedTypeReference<List<Student>> studentRef = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<Student>> response = this.restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, studentRef);

        if (OK.value() == response.getStatusCode().value()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Got an unexpected response from University Service");
        }
    }
}
