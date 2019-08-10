package com.graphql.demo.service;

import com.graphql.demo.domain.Degree;
import com.graphql.demo.domain.Student;
import com.graphql.demo.domain.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAllStudents() {
        return List.of(
                new Student("artemas", "muzanenhamo", new Degree("software engineering"), tutor("software engineering")),
                new Student("thomas", "jenkins", new Degree("bio-chemistry"), tutor("bio-chemistry")),
                new Student("sarah", "smith", new Degree("computer science"), tutor("computer science"))
        );
    }

    private Tutor tutor(String degree) {
        return List.of(
                new Tutor("jessica", "stevens", new Degree("software engineering")),
                new Tutor("randal", "macbeth", new Degree("computer science")),
                new Tutor("lavern", "masoja", new Degree("bio-chemistry"))
        ).stream()
                .filter(tutor -> tutor.getDegree().getDegree().equals(degree))
                .findFirst()
                .orElse(new Tutor());
    }
}
