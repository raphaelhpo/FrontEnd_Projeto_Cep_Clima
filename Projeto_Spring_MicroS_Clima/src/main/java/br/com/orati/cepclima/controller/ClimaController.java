package br.com.orati.cepclima.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.orati.cepclima.dto.create.CreateClimaDTO;
import br.com.orati.cepclima.dto.create.CreateCoordenadasDTO;
import br.com.orati.cepclima.dto.response.ResponseClimaDTO;
import br.com.orati.cepclima.service.ClimaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    ClimaService service;

    private ClimaController(ClimaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseClimaDTO getClima(
            @RequestParam Double latitude,
            @RequestParam Double longitude) {

        CreateCoordenadasDTO coords = new CreateCoordenadasDTO(latitude, longitude);
        CreateClimaDTO climaDTO = service.buscarDadosClient(coords);

        return climaDTO.toResponse();
    }

}
