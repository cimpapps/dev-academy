package com.orange.devacademy.mediaservice.service;

import com.orange.devacademy.mediaservice.model.Media;
import com.orange.devacademy.mediaservice.model.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class FavouritesService {

    private final UserService userService;

    private final MoviesService moviesService;

    public FavouritesService(MoviesService moviesService, UserService userService) {
        this.moviesService = moviesService;
        this.userService = userService;
    }

    public void addToFavourites(String movieId) {
        User user = userService.currentUser();
        Set<String> favouriteMovieIds = user.getFavouriteMovieIds();
        if (favouriteMovieIds == null) {
            favouriteMovieIds = new HashSet<>();
        }
        favouriteMovieIds.add(movieId);
        user.setFavouriteMovieIds(favouriteMovieIds);
        userService.saveUser(user);
    }

    public void removeFavourite(String movieId) {
        User user = userService.currentUser();
        Set<String> favouriteMovieIds = user.getFavouriteMovieIds();
        if (favouriteMovieIds == null) {
            return;
        }
        if (favouriteMovieIds.remove(movieId)) {
            user.setFavouriteMovieIds(favouriteMovieIds);
            userService.saveUser(user);
        }
    }

    public Set<Media> getFavourites() {
        User user = userService.currentUser();
        Set<String> favouriteMovieIds = user.getFavouriteMovieIds();
        if (favouriteMovieIds == null || favouriteMovieIds.isEmpty()) {
            return Collections.emptySet();
        }
        return moviesService.getAllById(favouriteMovieIds);
    }

}
