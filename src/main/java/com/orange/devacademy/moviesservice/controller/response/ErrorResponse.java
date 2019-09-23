package com.orange.devacademy.moviesservice.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {
    @JsonProperty(value = "code")
    @NonNull
    private Integer code;

    @JsonProperty(value = "message")
    @NonNull
    private String message;
}
