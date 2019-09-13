package com.graphql.demo.web;

import com.graphql.demo.domain.Tutor;
import com.graphql.demo.service.TutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class TutorController {
    private TutorService tutorService;
    private final static String TUTOR_URL = "/api/university/tutor";

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping(value = TUTOR_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Tutor> getAllTutors() {
        return tutorService.getAllTutors();
    }
}
