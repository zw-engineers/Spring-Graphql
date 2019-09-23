package com.graphql.demo.graphql.fetchers;

import com.graphql.demo.service.degree.DegreeService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public class DegreeDataFetcher {

    private final DegreeService degreeService;

    public DegreeDataFetcher(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    public DataFetcher getAllDegrees() {
        return dataFetchingEnvironment -> this.degreeService.getAllDegrees();
    }

    public DataFetcher getDegreeByTitle() {

        return dataFetchingEnvironment -> {
            String degree = dataFetchingEnvironment.getArgument("degree");
            return this.degreeService.getDegreeByTitle(degree);
        };
    }
}
