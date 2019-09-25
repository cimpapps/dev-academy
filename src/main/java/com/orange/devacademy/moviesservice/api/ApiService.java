package com.orange.devacademy.moviesservice.api;

import com.orange.devacademy.moviesservice.configuration.ApiProperties;
import com.orange.devacademy.moviesservice.model.Movie;
import com.orange.devacademy.moviesservice.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ApiService {

    private final MoviesRepository moviesRepository;
    private final ApiProperties apiProperties;

    @Autowired
    public ApiService(MoviesRepository moviesRepository, ApiProperties apiProperties) {
        this.moviesRepository = moviesRepository;
        this.apiProperties = apiProperties;
    }

    @Scheduled(fixedDelayString = "${movies-service.check-frequency}")
    public void doSomething() {
        RestTemplate restTemplate = new RestTemplate();
        String title = apiProperties.getAvailableMovies()[new Random().nextInt(apiProperties.getAvailableMovies().length - 1)];
        HttpEntity<Movie> response = restTemplate.exchange(
                apiProperties.getApiUri() + title,
                HttpMethod.GET,
                null,
                Movie.class);
        Movie newMovie = response.getBody();
        System.out.println(newMovie);
        moviesRepository.save(newMovie);
    }
}
