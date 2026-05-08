package br.com.orati.cepclima.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.orati.cepclima.dto.ExceptionFormatDTO;
import br.com.orati.cepclima.exceptions.CoordenadasInvalidasException;
import br.com.orati.cepclima.exceptions.FindIdException;
import feign.FeignException;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(CoordenadasInvalidasException.class)
    public ResponseEntity<ExceptionFormatDTO> coordenadasInvalidasException(CoordenadasInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionFormatDTO(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(FindIdException.class)
    public ResponseEntity<ExceptionFormatDTO> findIdException(FindIdException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionFormatDTO(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionFormatDTO> feignException(FeignException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionFormatDTO(HttpStatus.BAD_REQUEST, "Erro ao chamar API clima."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionFormatDTO> exceptionGlobal(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionFormatDTO(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
