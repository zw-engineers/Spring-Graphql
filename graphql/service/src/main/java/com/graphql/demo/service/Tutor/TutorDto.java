package com.graphql.demo.service.Tutor;

import com.graphql.demo.service.degree.Degree;

public class TutorDto {
    private String name;
    private String surname;
    private Degree degree;

    public TutorDto() { }

    public TutorDto(String name, String surname, Degree degree) {
        this.name = name;
        this.surname = surname;
        this.degree = degree;
    }
}
