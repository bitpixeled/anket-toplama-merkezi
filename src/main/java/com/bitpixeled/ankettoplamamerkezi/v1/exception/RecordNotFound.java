package com.bitpixeled.ankettoplamamerkezi.v1.exception;

public class RecordNotFound extends RuntimeException {

    @Override
    public String getMessage() {
        return "Aradiginiz kayit bulunamadi";
    }
}
