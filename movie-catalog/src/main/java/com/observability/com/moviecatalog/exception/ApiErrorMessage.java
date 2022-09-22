package com.observability.com.moviecatalog.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static java.util.Objects.isNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorMessage {

    private String code;
    private String description;

    public static ApiErrorMessage create(final ApiErrorType error, String description) {

        if(isNull(description)){
            description = error.getDescription();
        }

        return ApiErrorMessage.builder()
            .code(error.getCode())
            .description(description)
            .build();
    }
}
