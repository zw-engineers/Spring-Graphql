package com.graphql.demo.service.Tutor;

import java.util.List;

public interface TutorService {
    TutorDto getTutorByDegree(String degree);

    List<TutorDto> getAllTutors();
}
