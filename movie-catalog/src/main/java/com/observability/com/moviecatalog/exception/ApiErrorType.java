package com.observability.com.moviecatalog.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiErrorType {
    NOT_FOUND(400, "400", "Movie not found");

    private final int status;
    private final String code;
    private final String description;
}
