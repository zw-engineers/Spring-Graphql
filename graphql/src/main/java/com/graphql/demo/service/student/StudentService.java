package com.graphql.demo.service.student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentByName(final String name);

    StudentDto getStudentByDegree(String degree);
}
