package br.com.orati.cepclima.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.orati.cepclima.model.Cep;

@FeignClient(name = "cep", url = "https://cep.awesomeapi.com.br")
public interface CepApiService {

    @GetMapping("/json/{cep}")
    public Cep buscarDadosCep(@PathVariable("cep") String cepDTO);
}
