package com.graphql.demo.domain;

import java.util.List;
import java.util.Objects;

public class Tutor {
    private String name;
    private String surname;
    private Degree degree;
    private List<Student> students;

    public Tutor(String name, String surname, Degree degree, List<Student> students) {
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(name, tutor.name) &&
                Objects.equals(surname, tutor.surname) &&
                Objects.equals(degree, tutor.degree) &&
                Objects.equals(students, tutor.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, degree, students);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", degree=" + degree +
                ", students=" + students +
                '}';
    }
}
