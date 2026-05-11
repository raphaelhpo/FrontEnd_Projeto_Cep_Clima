package br.com.orati.cepclima.handlers;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.com.orati.cepclima.dto.response.RestErrorResponseDTO;
import br.com.orati.cepclima.exceptions.CepInvalidoException;
import br.com.orati.cepclima.exceptions.CepVazioException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(CepInvalidoException.class)
    public ResponseEntity<RestErrorResponseDTO> handlerCepInvalido(CepInvalidoException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String stackTrace = Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));
        RestErrorResponseDTO response = new RestErrorResponseDTO("CEP inválido.", status, stackTrace);
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(CepVazioException.class)
    public ResponseEntity<RestErrorResponseDTO> handlerCepVazio(CepVazioException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String stackTrace = Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));
        RestErrorResponseDTO response = new RestErrorResponseDTO("CEP Vazio.", status, stackTrace);
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<RestErrorResponseDTO> handlerRotaNaoEncontrada(NoResourceFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String stackTrace = Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));
        RestErrorResponseDTO response = new RestErrorResponseDTO("NOT_FOUND", status, stackTrace);
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorResponseDTO> handlerExcpetionGeneric(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String stackTrace = Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));
        RestErrorResponseDTO response = new RestErrorResponseDTO("Erro interno do servidor.", status, stackTrace);
        return ResponseEntity.status(status).body(response);
    }
}
