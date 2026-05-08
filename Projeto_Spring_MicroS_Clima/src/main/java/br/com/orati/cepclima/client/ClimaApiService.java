package br.com.orati.cepclima.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.orati.cepclima.dto.create.CreateClimaDTO;

@FeignClient(name = "openMeteoAPI", url = "https://api.open-meteo.com/v1")
public interface ClimaApiService {

    @GetMapping("/forecast?current=temperature_2m,apparent_temperature,weather_code,wind_speed_10m&timezone=auto")
    CreateClimaDTO buscarDadosClima(
            @RequestParam String latitude,
            @RequestParam String longitude);
}
