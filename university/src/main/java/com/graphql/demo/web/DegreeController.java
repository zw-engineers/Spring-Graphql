package com.graphql.demo.web;

import com.graphql.demo.domain.Degree;
import com.graphql.demo.service.DegreeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class DegreeController {
    private DegreeService degreeService;
    private static final String DEGREE_URL = "/api/university/degree";

    public DegreeController(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    @GetMapping(value = DEGREE_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Degree> getAllDegrees() {
        return degreeService.getAllDegrees();
    }
}
