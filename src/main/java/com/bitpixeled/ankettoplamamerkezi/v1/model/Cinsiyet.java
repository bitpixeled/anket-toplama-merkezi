package com.bitpixeled.ankettoplamamerkezi.v1.model;

public enum Cinsiyet {

    K(0), E(1);

    private final int asInt;

    Cinsiyet(int asInt) {
        this.asInt = asInt;
    }

    public int getAsInt() {
        return asInt;
    }
}
