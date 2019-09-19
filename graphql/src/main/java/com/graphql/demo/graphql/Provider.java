package com.graphql.demo.graphql;

import com.google.common.base.Charsets;
import com.graphql.demo.graphql.fetchers.DegreeDataFetcher;
import com.graphql.demo.graphql.fetchers.StudentDataFetcher;
import com.graphql.demo.graphql.fetchers.TutorDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

import static com.google.common.io.Resources.*;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class Provider {

    private final StudentDataFetcher studentDataFetcher;
    private final DegreeDataFetcher degreeDataFetcher;
    private final TutorDataFetcher tutorDataFetcher;

    public Provider(StudentDataFetcher studentDataFetcher, DegreeDataFetcher degreeDataFetcher, TutorDataFetcher tutorDataFetcher) {
        this.studentDataFetcher = studentDataFetcher;
        this.degreeDataFetcher = degreeDataFetcher;
        this.tutorDataFetcher = tutorDataFetcher;
    }

    @Bean
    public GraphQL graphQL() throws IOException {
        URL url = getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);

        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("getStudentByName", this.studentDataFetcher.getStudentByName())
                        .dataFetcher("getAllStudents", this.studentDataFetcher.getAllStudents())
                        .dataFetcher("getStudentByDegree", this.studentDataFetcher.getStudentByDegree())
                        .dataFetcher("getStudentByTutor", this.studentDataFetcher.getStudentByTutor())
                        .dataFetcher("getDegreeByTitle", this.degreeDataFetcher.getDegreeByTitle())
                        .dataFetcher("getAllDegrees", this.degreeDataFetcher.getAllDegrees())
                        .dataFetcher("getTutorByDegree", this.tutorDataFetcher.getTutorByDegree())
                )
                .type(newTypeWiring("Student")
                        .dataFetcher("getAllStudents", this.studentDataFetcher.getAllStudents())
                )
                .build();
    }
}
