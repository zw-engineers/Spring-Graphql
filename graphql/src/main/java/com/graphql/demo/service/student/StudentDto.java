package com.graphql.demo.service.student;

public class StudentDto {
    private String name;
    private String surname;

    public StudentDto() {
    }

    public StudentDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
