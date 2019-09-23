package com.orange.devacademy.moviesservice.controller.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum RestErrorCode {

    // 400
    MISSING_HEADER(25),
    INVALID_HEADER_VALUE(26),
    MISSING_QUERY_STRING_PARAMETER(27),
    INVALID_QUERY_STRING_PARAMETER_VALUE(28),
    // 401
    MISSING_CREDENTIALS(40),
    INVALID_CREDENTIALS(41),
    // 403
    ACCESS_DENIED(50),
    // 404
    RESOURCE_NOT_FOUND(60),
    // 500
    INTERNAL_ERROR(1);

    @Getter
    private int code;
}
