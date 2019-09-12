package com.graphql.demo.service.student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudentByName();

    StudentDto getStudentByName(final String name);
}
