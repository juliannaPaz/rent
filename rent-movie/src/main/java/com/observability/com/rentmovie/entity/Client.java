package com.observability.com.rentmovie.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "client")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private String id;
    private String name;
    private int age;

}
