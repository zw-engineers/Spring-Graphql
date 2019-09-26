package com.graphql.service.degree;

import java.util.List;

public interface DegreeService {
    List<DegreeDto> getAllDegrees();

    DegreeDto getDegreeByTitle(String degree);
}
