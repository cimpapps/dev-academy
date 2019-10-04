package com.orange.devacademy.mediaservice.controller;

import com.orange.devacademy.mediaservice.model.Media;
import com.orange.devacademy.mediaservice.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.orange.devacademy.mediaservice.configuration.MediaConstants.API_V1;

@RestController
@RequestMapping(API_V1)
public class MoviesController {

    private final MoviesService moviesService;


    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping(value = "/GetMedia", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getMyMovies(@RequestParam(required = false) String title) {
        if (title != null)
            return moviesService.getMovieByTitle(title);

        return moviesService.getMyMovies();
    }
}
