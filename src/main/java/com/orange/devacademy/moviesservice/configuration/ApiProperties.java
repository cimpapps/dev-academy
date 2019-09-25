package com.orange.devacademy.moviesservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "movies-service")
public class ApiProperties {

    private String apiUri;
    private String[] availableMovies;
    private Authentication authentication;

    @Getter
    @Setter
    public static class Authentication {
        List<User> users;
    }

    @Getter
    @Setter
    public static class User {
        private String username;
        private String password;
        private String[] roles;
    }
}
