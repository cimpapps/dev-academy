package com.orange.devacademy.moviesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;


    private List<Movie> myMovies;

}
