package org.bebra.oscarserver.web;

import org.bebra.soacommons.model.dto.MovieDto;
import org.bebra.soacommons.model.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieClient {
    private final RestTemplate restTemplate;

    @Autowired
    public MovieClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PageDto<MovieDto> getMovies(int page, int size) {
        return restTemplate.exchange(
                "http://host.docker.internal:1234/movie-web-1.0-SNAPSHOT/api/v1/movie?page={page}&size={size}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageDto<MovieDto>>() {},
                page,
                size
        ).getBody();
    }

    public void updateMovie(Integer id, MovieDto movieDto) {
        restTemplate.put("http://host.docker.internal:1234/movie-web-1.0-SNAPSHOT/api/v1/movie/{id}", movieDto, id);
    }
}
