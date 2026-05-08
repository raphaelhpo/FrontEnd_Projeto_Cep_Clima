package br.com.orati.cepclima.dto.create;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.orati.cepclima.model.Cep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCepDTO {
    String cep;
    @JsonAlias("address")
    String logradouroCompleto;
    @JsonAlias("state")
    String uf;
    @JsonAlias("district")
    String bairro;
    @JsonAlias("lat")
    String latitude;
    @JsonAlias("lng")
    String longitude;
    @JsonAlias("city")
    String cidade;
    String ddd;

    public Cep toEntity() {
        Cep cepObj = new Cep();
        cepObj.setCep(cep);
        cepObj.setLogradouroCompleto(logradouroCompleto);
        cepObj.setUf(uf);
        cepObj.setBairro(bairro);
        cepObj.setLatitude(latitude);
        cepObj.setLongitude(longitude);
        cepObj.setCidade(cidade);
        return cepObj;
    }

}
