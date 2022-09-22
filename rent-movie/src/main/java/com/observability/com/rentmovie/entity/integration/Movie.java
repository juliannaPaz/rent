package com.observability.com.rentmovie.entity.integration;

import java.math.BigDecimal;

public record Movie(String id, String name, BigDecimal value, int year, int ageGroup) {

}
