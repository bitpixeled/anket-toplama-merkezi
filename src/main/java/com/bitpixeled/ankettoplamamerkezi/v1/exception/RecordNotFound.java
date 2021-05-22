package com.bitpixeled.ankettoplamamerkezi.v1.exception;

public class RecordNotFound extends RuntimeException {


    public RecordNotFound(String message) {
        super(message);
    }

    public RecordNotFound() {
        super("Aradığınız kayıt bulunamadı");
    }
}
