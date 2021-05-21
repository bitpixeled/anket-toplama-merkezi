package com.bitpixeled.ankettoplamamerkezi.v1.exception;

public class RecordNotFound extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message != null ? this.message : "Aradığınız kayıt bulunamadı";
    }

    public RecordNotFound(String message) {
        this.message = message;
    }

    public RecordNotFound() {
    }
}
