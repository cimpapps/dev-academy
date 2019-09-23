package com.orange.devacademy.moviesservice.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Rating implements Serializable {
    VERY_BAD(1),
    BAD(2),
    OK(3),
    GOOD(4),
    VERY_GOOD(5);

    private Integer grade;

    Rating(Integer grade) {
        this.grade = grade;
    }

    @JsonValue
    public Integer getGrade() {
        return grade;
    }
}
