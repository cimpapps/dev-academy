package com.orange.devacademy.mediaservice.controller;

import com.orange.devacademy.mediaservice.model.Media;
import com.orange.devacademy.mediaservice.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class FavouritesController {

    private FavouritesService favouritesService;

    @Autowired
    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @DeleteMapping(value = "/favourites")
    public void removeFavourite(@RequestParam String movieId) {
        favouritesService.removeFavourite(movieId);
    }

    @PutMapping(value = "/favourites", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFavourite(@RequestParam String movieId) {
        favouritesService.addToFavourites(movieId);
    }

    @GetMapping(value = "/favourites", produces= MediaType.APPLICATION_JSON_VALUE)
    public Set<Media> getFavourites() {
        return favouritesService.getFavourites();
    }
}
