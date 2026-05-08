package br.com.orati.cepclima.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orati.cepclima.dto.create.CreateCepDTO;
import br.com.orati.cepclima.dto.response.ResponseDTO;
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
    public ResponseEntity<ResponseDTO> postMethodName(@PathVariable("cep") String cep) {
        ResponseDTO retorno = service.create(cep);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

}
