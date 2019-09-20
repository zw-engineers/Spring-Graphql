package com.graphql.demo.service.degree;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

@Service
public class DegreeServiceImpl implements DegreeService {
    private static final String URL = "http://localhost:8081/api/university/degree";
    private final RestTemplate restTemplate;

    public DegreeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<DegreeDto> getAllDegrees() {
        List<Degree> degrees = getDegrees();
        return convertDegreesToDTO(degrees);
    }

    @Override
    public DegreeDto getDegreeByTitle(String degree) {
        return getAllDegrees()
                .stream()
                .filter(e -> e.getDegree().contains(degree))
                .findFirst()
                .orElse(new DegreeDto());
    }

    private List<DegreeDto> convertDegreesToDTO(List<Degree> degrees) {
        return degrees
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DegreeDto convertToDTO(Degree degree) {
        return new DegreeDto(degree.getDegree());
    }

    private List<Degree> getDegrees() {
        ParameterizedTypeReference<List<Degree>> degreeTypeRef = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<Degree>> response = this.restTemplate.exchange(URL, GET, EMPTY, degreeTypeRef);

        if (OK.value() == response.getStatusCode().value()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Got an unexpected response from University Service retrieving Degree");
        }
    }
}
