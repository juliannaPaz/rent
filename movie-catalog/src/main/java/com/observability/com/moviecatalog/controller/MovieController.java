package com.observability.com.moviecatalog.controller;

import com.observability.com.moviecatalog.entity.Movie;
import com.observability.com.moviecatalog.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    @Value("${spring.data.mongodb.uri}")
    private String mongoUrl;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> findAll(){
        log.info("Conexão com banco {}", mongoUrl);
        var movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping
    public ResponseEntity<Movie> findById(@RequestParam(value = "id", required = true) String id){
        var movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/generated")
    public void generatedBaseToTest(){
        movieService.createMoviesTest();
    }

}
