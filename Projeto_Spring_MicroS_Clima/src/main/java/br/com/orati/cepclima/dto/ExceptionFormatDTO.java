package br.com.orati.cepclima.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionFormatDTO {
    HttpStatus error;
    String message;
}
