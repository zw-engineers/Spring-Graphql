package com.graphql.demo.service.Tutor;

import com.graphql.demo.service.degree.Degree;

import java.util.Objects;

public class Tutor {
    private String name;
    private String surname;
    private Degree degree;

    public Tutor() { }

    public Tutor(String name, String surname, Degree degree) {
        this.name = name;
        this.surname = surname;
        this.degree = degree;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(name, tutor.name) &&
                Objects.equals(surname, tutor.surname) &&
                Objects.equals(degree, tutor.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, degree);
    }
}
