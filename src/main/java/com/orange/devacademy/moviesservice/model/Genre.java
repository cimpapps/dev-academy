package com.orange.devacademy.moviesservice.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Genre implements Serializable {
    COMEDY("Comedy"),
    ROMANCE("Romance"),
    ACTION("Action"),
    DRAMA("Drama"),
    ADVENTURE("Adventure"),
    FANTASY("Fantasy"),
    CRIME("Crime"),
    ANIMATION("Animation");

    private String displayValue;

    Genre(String displayValue) {
        this.displayValue = displayValue;
    }

    @JsonValue
    public String getDisplayValue() {
        return displayValue;
    }
}
