package me.mirat1618.apartmentsapi.exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
