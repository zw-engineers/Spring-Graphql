package com.graphql.service.student;

import com.graphql.service.Tutor.Tutor;
import com.graphql.service.degree.Degree;

import java.util.Objects;

public class StudentDto {
    private String name;
    private String surname;
    private Degree degree;
    private Tutor tutor;

    public StudentDto() { }

    public StudentDto(String name, String surname, Degree degree, Tutor tutor) {
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.tutor = tutor;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Degree getDegree() {
        return degree;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(degree, that.degree) &&
                Objects.equals(tutor, that.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, degree, tutor);
    }
}
