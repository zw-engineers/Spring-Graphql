package com.graphql.demo.service;

import com.graphql.demo.domain.Degree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService {

    @Override
    public List<Degree> getAllDegrees() {
        return List.of(
                new Degree("software engineering"),
                new Degree("bio-chemistry"),
                new Degree("computer science")
        );
    }
}
