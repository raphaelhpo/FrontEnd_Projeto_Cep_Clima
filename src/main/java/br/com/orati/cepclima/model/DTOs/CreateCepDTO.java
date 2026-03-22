package br.com.orati.cepclima.model.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateCepDTO(
        @NotBlank @NotEmpty @Size(min = 8, max = 9) String cep) {

}
