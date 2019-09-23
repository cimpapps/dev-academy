package com.orange.devacademy.moviesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MoviesserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviesserviceApplication.class, args);
	}

}
