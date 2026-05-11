package br.com.orati.cepclima.dto.create;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.orati.cepclima.model.Cep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCepDTO {
    String cep;
    @JsonProperty("address")
    String logradouroCompleto;
    @JsonProperty("state")
    String uf;
    @JsonProperty("district")
    String bairro;
    @JsonProperty("lat")
    String latitude;
    @JsonProperty("lng")
    String longitude;
    @JsonProperty("city")
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
        cepObj.setDdd(ddd);
        return cepObj;
    }

}
