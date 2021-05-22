package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SoruDto {

    private Long Id;
    private String soru;
    private boolean numeric;
    private Long anketId;

}
