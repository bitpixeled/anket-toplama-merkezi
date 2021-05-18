package com.bitpixeled.ankettoplamamerkezi.v1.model;

public enum Gender {

    F(0), M(1);

    private final int asInt;

    Gender(int asInt) {
        this.asInt = asInt;
    }

    public int getAsInt() {
        return asInt;
    }
}
