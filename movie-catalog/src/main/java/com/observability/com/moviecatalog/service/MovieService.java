package com.observability.com.moviecatalog.service;

import com.observability.com.moviecatalog.entity.Movie;
import com.observability.com.moviecatalog.service.exception.MovieNotFoundException;
import com.observability.com.moviecatalog.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public void createMoviesTest(){
       var moviesToPersist = Arrays.asList(Movie.builder()
            .name("Senhor dos Anéis")
            .value(BigDecimal.valueOf(15))
            .year(2001)
            .ageGroup(16)
                .build(),
            Movie.builder()
                .name("Uma Linda Mulher")
                .value(BigDecimal.valueOf(5))
                .year(1990)
                .ageGroup(12)
                .build(),
            Movie.builder()
                .name("Vingadores: Ultimato")
                .value(BigDecimal.valueOf(10))
                .year(2019)
                .ageGroup(12)
                .build(),
            Movie.builder()
                .name("Silêncio dos Inocentes")
                .value(BigDecimal.valueOf(10))
                .year(1991)
                .ageGroup(16)
                .build(),
           Movie.builder()
               .name("Corra que a polícia vem ai")
               .value(BigDecimal.valueOf(3))
               .year(1988)
               .ageGroup(1)
               .build(),
           Movie.builder()
               .name("Curtindo a Vida Adoidado")
               .value(BigDecimal.valueOf(6.50))
               .year(1986)
               .ageGroup(1)
               .build());

       movieRepository.saveAll(moviesToPersist);
    }

    public Movie findById(String id){
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Filme com código informado não encontrado"));
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

}
