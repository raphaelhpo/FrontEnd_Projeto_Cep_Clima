package br.com.orati.cepclima.dto;

import java.time.LocalDateTime;

import br.com.orati.cepclima.model.Clima;

public record CreateClimaDTO(
                LocalDateTime data,
                Float temperatura,
                Float sensacaoTermica,
                Integer condicaoClimatica,
                Integer velocidadeVento) {
        public Clima toEntity() {
                Clima clima = new Clima();
                clima.setData(data);
                clima.setTemperatura(temperatura);
                clima.setSensacaoTermica(sensacaoTermica);
                clima.setCondicaoClimatica(condicaoClimatica);
                clima.setVelocidadeVento(velocidadeVento);
                return clima;

        }
}
