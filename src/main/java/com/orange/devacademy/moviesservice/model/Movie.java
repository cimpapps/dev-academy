package com.orange.devacademy.moviesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie {
    private String title;
    private String description;
    private String director;
    private LocalDate releaseDate;
    private Float duration;
    private Rating rating;
    private Genre genre;
    private List<String> cast;
}
