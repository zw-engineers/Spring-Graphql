package com.graphql.demo.graphql.fetchers;

import com.graphql.demo.service.Tutor.TutorService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public class TutorDataFetcher {
    private final TutorService tutorService;

    public TutorDataFetcher(TutorService tutorService) {
        this.tutorService = tutorService;
    }


    public DataFetcher getTutorByDegree() {
        return dataFetchingEnvironment -> {
            String degree = dataFetchingEnvironment.getArgument("degree");
            return this.tutorService.getTutorByDegree(degree);
        };
    }

    public DataFetcher getAllTutors() {
        return dataFetchingEnvironment -> this.tutorService.getAllTutors();
    }
}
