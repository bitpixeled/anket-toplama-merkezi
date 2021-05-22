package com.bitpixeled.ankettoplamamerkezi.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IdDidNotMatch extends RuntimeException {

    private final Long pathId;
    private final Long entityId;
}
