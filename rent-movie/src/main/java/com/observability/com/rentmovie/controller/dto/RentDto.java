package com.observability.com.rentmovie.controller.dto;

import com.observability.com.rentmovie.entity.Rent;

import java.time.LocalDateTime;
import java.util.Set;

public record RentDto(String clientId, LocalDateTime dateDevolution, Set<String> movies) {

    public Rent from(RentDto rentDto){
        return Rent.builder()
            .clientId(clientId)
            .dateDevolution(dateDevolution)
            .movies(movies)
            .build();
    }
}
