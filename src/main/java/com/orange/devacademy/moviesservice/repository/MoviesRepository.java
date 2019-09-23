package com.orange.devacademy.moviesservice.repository;


import com.orange.devacademy.moviesservice.model.Genre;
import com.orange.devacademy.moviesservice.model.Movie;
import com.orange.devacademy.moviesservice.model.Rating;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository {

    public List<Movie> findMovies() {
        List<Movie> myMovies = new ArrayList<>();

        List<String> cast = new ArrayList<>();
        cast.add("Leonardo Dicaprio");
        cast.add("Brad Pitt");

        Movie movie1 = new Movie();
        movie1.setTitle("Once upon a time");
        movie1.setDescription("Un film de Tarantino");
        movie1.setDirector("Tarantino");
        movie1.setDescription("Un film misto cu Dicaprio si Brad");
        movie1.setReleaseDate(LocalDate.now());
        movie1.setDuration(120f);
        movie1.setCast(cast);
        movie1.setGenre(Genre.ACTION);
        movie1.setRating(Rating.VERY_GOOD);

        Movie movie2 = new Movie();
        movie2.setTitle("Interstellar");
        movie2.setDescription("Un film de Joey");
        movie2.setDirector("Joey");
        movie2.setDescription("Un film misto cu Dicaprio si Brad de Joey");
        movie2.setReleaseDate(LocalDate.now());
        movie2.setDuration(120f);
        movie2.setCast(cast);
        movie2.setGenre(Genre.FANTASY);
        movie2.setRating(Rating.VERY_GOOD);

        myMovies.add(movie1);
        myMovies.add(movie2);

        return myMovies;
    }
}
