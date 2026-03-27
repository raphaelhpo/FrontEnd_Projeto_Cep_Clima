package br.com.orati.cepclima.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orati.cepclima.model.DTOs.CreateCepDTO;
import br.com.orati.cepclima.model.DTOs.ResponseCepDTO;
import br.com.orati.cepclima.service.CepService;

@RestController
@RequestMapping("/api/cep")
@Validated
public class CepController {
    CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    /**
     * 
     * @param cep
     * @return
     */
    @PostMapping("/{cep}")
    public ResponseEntity<ResponseCepDTO> postMethodName(@PathVariable CreateCepDTO cep) {
        ResponseCepDTO retorno = service.create(cep);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

}
