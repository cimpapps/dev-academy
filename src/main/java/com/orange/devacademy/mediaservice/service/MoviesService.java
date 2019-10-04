package com.orange.devacademy.mediaservice.service;

import com.orange.devacademy.mediaservice.model.Media;
import com.orange.devacademy.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final MediaRepository mediaRepository;

    @Autowired
    public MoviesService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getMyMovies() {
        return mediaRepository.findAll();
    }

    public List<Media> getMovieByTitle(String title) {
        return mediaRepository.findAllByTitleMatchesRegex("(?i).*" + title + ".*");
    }
}
