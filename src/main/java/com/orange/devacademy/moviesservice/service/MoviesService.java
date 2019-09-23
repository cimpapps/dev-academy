package com.orange.devacademy.moviesservice.service;

import com.orange.devacademy.moviesservice.model.Movie;
import com.orange.devacademy.moviesservice.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Scheduled(fixedDelay = 10000)
    public void doSomething() {
        System.out.println("Halo");
    }

    public List<Movie> getMyMovies() {
        return moviesRepository.findMovies();
    }
}
