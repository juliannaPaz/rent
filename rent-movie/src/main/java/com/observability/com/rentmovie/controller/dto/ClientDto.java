package com.observability.com.rentmovie.controller.dto;

import com.observability.com.rentmovie.entity.Client;

public record ClientDto(String name, int age) {

    public Client from(ClientDto clientDto){
        return Client.builder()
            .name(clientDto.name)
            .age(clientDto.age)
            .build();
    }
}
