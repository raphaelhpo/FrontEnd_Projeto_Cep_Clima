package br.com.orati.cepclima.dto.create;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.orati.cepclima.dto.CurrentDTO;
import br.com.orati.cepclima.dto.response.ResponseClimaDTO;
import br.com.orati.cepclima.model.Clima;

public record CreateClimaDTO(
                @JsonAlias("current") CurrentDTO current) {

        public Clima toEntity() {
                Clima clima = new Clima();
                clima.setData(current.data());
                clima.setTemperatura(current.temperatura());
                clima.setSensacaoTermica(current.sensacaoTermica());
                clima.setCondicaoClimatica(current.condicaoClimatica());
                clima.setVelocidadeVento(current.velocidadeVento());
                return clima;
        }

        public ResponseClimaDTO toResponse() {
                return new ResponseClimaDTO(
                                current.data(),
                                current.temperatura(),
                                current.sensacaoTermica(),
                                current.condicaoClimatica(),
                                current.velocidadeVento());
        }
}
