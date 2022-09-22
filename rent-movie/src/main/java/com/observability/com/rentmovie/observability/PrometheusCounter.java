package com.observability.com.rentmovie.observability;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class PrometheusCounter {

    private final MeterRegistry meterRegistry;
    private static final String AMOUNT_RENT = "amount_rent";
    private static final String AMOUNT_RENT_MOVIES = "amount_rent_movies";
    private static final String AMOUNT_SALES = "amount_sales";

    public void amountRent() {
        var tag = new HashMap<>();
        meterRegistry.counter(AMOUNT_RENT, "rent", "quantidade de aluguéis").increment();
    }

    public void amountRentsMovie(final int size) {
        meterRegistry.counter(AMOUNT_RENT_MOVIES, "rent","quantidade de filmes").increment(size);
    }

    public void amountSales(final BigDecimal value) {
        meterRegistry.counter(AMOUNT_SALES, "rent","valor total em R$").increment(value.doubleValue());
    }
}
