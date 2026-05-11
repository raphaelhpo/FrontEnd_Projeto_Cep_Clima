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
    @JsonAlias("state")
    String uf;
    @JsonAlias("city")
    String cidade;
    @JsonAlias("neighborhood")
    String bairro;
    @JsonAlias("street")
    String logradouroCompleto;
    Location location;

    public Cep toEntity() {
        Cep cepObj = new Cep();
        cepObj.setCep(cep);
        cepObj.setLogradouroCompleto(logradouroCompleto);
        cepObj.setUf(uf);
        cepObj.setBairro(bairro);
        cepObj.setLatitude(location.getCoordinates().getLatitude());
        cepObj.setLongitude(location.getCoordinates().getLongitude());
        cepObj.setCidade(cidade);
        return cepObj;
    }

}
