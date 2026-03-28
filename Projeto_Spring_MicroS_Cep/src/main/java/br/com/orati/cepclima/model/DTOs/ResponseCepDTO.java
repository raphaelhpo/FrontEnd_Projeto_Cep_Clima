package br.com.orati.cepclima.model.DTOs;

import lombok.Data;
import lombok.Setter;

@Data
public class ResponseCepDTO {
    String cep;
    String latitude;
    String longitude;
}
