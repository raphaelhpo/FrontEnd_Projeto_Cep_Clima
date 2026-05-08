package br.com.orati.cepclima.exceptions;

public class FindIdException extends RuntimeException {
    public FindIdException(String message) {
        super(message);
    }

    public FindIdException() {
        super();
    }
}
