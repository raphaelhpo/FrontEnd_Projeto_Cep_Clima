package br.com.orati.cepclima.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Clima {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id;
        LocalDateTime data;
        Float temperatura;
        Float sensacaoTermica;
        Integer condicaoClimatica;
        Float velocidadeVento;
}
