package br.com.rhfactor.cms.infrastructure.error.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String message) {
        super(message);
    }

}
