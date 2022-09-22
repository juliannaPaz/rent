package com.observability.com.rentmovie.service;

import com.observability.com.rentmovie.entity.Rent;
import com.observability.com.rentmovie.entity.integration.Movie;
import com.observability.com.rentmovie.observability.PrometheusCounter;
import com.observability.com.rentmovie.observability.PrometheusGauge;
import com.observability.com.rentmovie.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final RestTemplate restTemplate;

    private final PrometheusCounter prometheusCounter;
    private final PrometheusGauge prometheusGauge;

    @Value("${spring.application.movie.url}")
    private String urlMovie;

    public void rentMovies(Rent rent) {
        rent.generatedValueTotal();
        rent.getMovies().forEach(idMovie -> {
            findMovieById(idMovie).orElseThrow(() ->
                new NotFoundException("Filme com identificador  " + idMovie + " não foi encontrado"));
        });

        /**
         * Usando as métricas do Prometheus do tipo counter
         */
        prometheusCounter.amountRent();
        prometheusCounter.amountRentsMovie(rent.getMovies().size());
        prometheusCounter.amountSales(rent.getTotal());

        /**
         * Usando as métricas do Prometheus do tipo gauge
         */
        prometheusGauge.countMovie(rent.getMovies().size());
        prometheusGauge.amountSales(rent.getTotal());

        rentRepository.save(rent);
    }

    private Optional<Movie> findMovieById(String idMovie) {
        var url = urlMovie + "?id={id}";
        var params = new HashMap<String, String>();
        params.put("id", idMovie);
        return Optional.ofNullable(restTemplate.getForObject(url, Movie.class, params));
    }

}
