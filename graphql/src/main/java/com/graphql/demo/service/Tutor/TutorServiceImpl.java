package com.graphql.demo.service.Tutor;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

@Service
public class TutorServiceImpl implements TutorService {

    private static final String URL = "http://localhost:8081/api/university/tutor";
    private final RestTemplate restTemplate;

    public TutorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TutorDto getTutorByDegree(String degree) {
        return getAllTutorsFromClient()
                .stream()
                .filter(isTutorPresent(degree))
                .map(this::toTutorDto)
                .findFirst()
                .orElse(new TutorDto());
    }

    @Override
    public List<TutorDto> getAllTutors() {
        return getAllTutorsFromClient()
                .stream()
                .map(this::toTutorDto)
                .collect(Collectors.toList());
    }

    private Predicate<Tutor> isTutorPresent(String degree) {
        return tutor -> tutor.getDegree().getDegree().contains(degree);
    }

    private TutorDto toTutorDto(Tutor tutor) {
        return new TutorDto(tutor.getName(), tutor.getSurname(), tutor.getDegree());
    }

    private List<Tutor> getAllTutorsFromClient() {
        ParameterizedTypeReference<List<Tutor>> tutorTypeRef = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<Tutor>> responseEntity = this.restTemplate.exchange(URL, GET, EMPTY, tutorTypeRef);

        if (OK.value() == responseEntity.getStatusCode().value()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Got an unexpected response from University Service retrieving Tutor");
        }
    }
}
