package br.com.orati.cepclima.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseClimaDTO {
    LocalDateTime data;
    Float temperatura;
    Float sensacaoTermica;
    Integer condicaoClimatica;
    Float velocidadeVento;
}
