package br.com.orati.cepclima.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.orati.cepclima.dto.create.CreateCepDTO;

@FeignClient(name = "cep", url = "${service.clima.url}")
public interface CepClientService {

    @GetMapping("/json/{cep}")
    public CreateCepDTO buscarDadosCep(@PathVariable("cep") String cep);
}
