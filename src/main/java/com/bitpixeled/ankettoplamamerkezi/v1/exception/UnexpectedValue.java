package com.bitpixeled.ankettoplamamerkezi.v1.exception;

public class UnexpectedValue extends RuntimeException {

    private final String unExpectedValue;

    public UnexpectedValue(String unExpectedValue) {
        this.unExpectedValue = unExpectedValue;
    }

    public String getUnExpectedValue() {
        return unExpectedValue;
    }
}
