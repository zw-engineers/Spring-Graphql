package com.graphql.demo.service.degree;

public class DegreeDto {
    private String degree;

    public DegreeDto() { }

    public DegreeDto(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }
}
