package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CevapDto {

    private Long id;
    private String cevap;
    private Long soruId;
    private Long anketId;
    private Long katilimciId;
    private Long anketorId;
}
