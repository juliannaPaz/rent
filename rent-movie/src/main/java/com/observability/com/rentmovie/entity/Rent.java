package com.observability.com.rentmovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Document(collation = "rent")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rent {

    @Id
    private String id;
    private String clientId;
    private LocalDateTime dateRent = LocalDateTime.now();
    private BigDecimal total;
    private Set<String> movies;
    private LocalDateTime dateDevolution = LocalDateTime.now().plusDays(2);

    public void generatedValueTotal(){
        total = BigDecimal.valueOf(Math.random() * 100).abs();
    }

}
