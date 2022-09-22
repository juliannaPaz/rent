package com.observability.com.rentmovie.observability;


import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class PrometheusGauge {

    private final Gauge gauge;

    public PrometheusGauge(CollectorRegistry collectorRegistry) {
        gauge = Gauge.build()
            .name("rent_movie_gauge")
            .labelNames("rent")
            .help("Amostragem de alugueis com gauge")
            .register(collectorRegistry);
    }

    public void countMovie(final int size) {
        gauge.labels("quantidade de filmes").set(size);
    }

    public void amountSales(final BigDecimal value) {
        gauge.labels("valor total em R$").set(value.doubleValue());
    }

}
