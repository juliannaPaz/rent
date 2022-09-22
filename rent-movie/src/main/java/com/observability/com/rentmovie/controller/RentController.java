package com.observability.com.rentmovie.controller;

import com.observability.com.rentmovie.controller.dto.RentDto;
import com.observability.com.rentmovie.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("rent")
public class RentController {

    private final RentService rentService;

    @PostMapping("/movie")
    public ResponseEntity<Void> rentMovie(@RequestBody RentDto rentDto){
        log.info("Iniciando os trabalhos ");
        rentService.rentMovies(rentDto.from(rentDto));
        return ResponseEntity.ok().build();
    }
}
