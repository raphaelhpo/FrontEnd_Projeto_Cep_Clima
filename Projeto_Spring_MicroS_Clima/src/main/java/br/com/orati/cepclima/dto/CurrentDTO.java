package br.com.orati.cepclima.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CurrentDTO(
        @JsonAlias("time") LocalDateTime data,
        @JsonAlias("temperature_2m") Float temperatura,
        @JsonAlias("apparent_temperature") Float sensacaoTermica,
        @JsonAlias("weather_code") Integer condicaoClimatica,
        @JsonAlias("wind_speed_10m") Float velocidadeVento) {
}
