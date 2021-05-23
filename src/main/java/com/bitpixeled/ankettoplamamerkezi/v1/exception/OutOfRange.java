package com.bitpixeled.ankettoplamamerkezi.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OutOfRange extends RuntimeException {

    private final Integer outOfRange;
}
