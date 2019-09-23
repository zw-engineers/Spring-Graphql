package com.graphql.demo.service.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql.demo.service.Tutor.Tutor;
import com.graphql.demo.service.degree.Degree;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String name;
    private String surname;
    private Degree degree;
    private Tutor tutor;

    public Student() {
    }

    @JsonCreator
    public Student(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("degree") Degree degree,
            @JsonProperty("tutor") Tutor tutor ) {
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
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(degree, student.degree) &&
                Objects.equals(tutor, student.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, degree, tutor);
    }
}
