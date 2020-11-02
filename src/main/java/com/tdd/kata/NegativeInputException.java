package com.tdd.kata;

public class NegativeInputException extends RuntimeException {

    public NegativeInputException() {
    }

    public NegativeInputException(String message) {
        super(message);
    }
}
