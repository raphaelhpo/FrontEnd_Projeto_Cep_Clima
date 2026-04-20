package br.com.orati.cepclima.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.orati.cepclima.dto.CreateClimaDTO;

@FeignClient(name = "OpenMeteore", url = "https://api.open-meteo.com/v1/")
public interface ClimaApiService {

    @GetMapping("forecast?latitude=${latitude}&longitude=${longitude}&current=temperature_2m,apparent_temperature,weather_code,wind_speed_10m&daily=temperature_2m_max,temperature_2m_min&timezone=auto")
    CreateClimaDTO buscarDadosClima(
            @PathVariable("latitude") Integer lat,
            @PathVariable("longitude") Integer log);
}
