package br.com.orati.cepclima.exceptions;

public class CoordenadasInvalidasException extends RuntimeException {
    public CoordenadasInvalidasException() {
        super();
    }

    public CoordenadasInvalidasException(String message) {
        super(message);
    }
}
