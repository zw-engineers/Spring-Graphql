package com.graphql.demo.service;

import com.graphql.demo.domain.Degree;
import com.graphql.demo.domain.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    @Override
    public List<Tutor> getAllTutors() {
        return List.of(
                new Tutor("jessica", "stevens", new Degree("software engineering")),
                new Tutor("randal", "macbeth", new Degree("computer science")),
                new Tutor("lavern", "masoja", new Degree("bio-chemistry"))
        );
    }
}
