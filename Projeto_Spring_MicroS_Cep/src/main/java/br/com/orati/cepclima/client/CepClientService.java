package br.com.orati.cepclima.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.orati.cepclima.dto.create.CreateCepDTO;
import feign.Headers;

@FeignClient(name = "cep", url = "https://brasilapi.com.br/api/cep/v2")

public interface CepClientService {

    @GetMapping("/json/{cep}")
    public CreateCepDTO buscarDadosCep(@PathVariable("cep") String cep);
}
