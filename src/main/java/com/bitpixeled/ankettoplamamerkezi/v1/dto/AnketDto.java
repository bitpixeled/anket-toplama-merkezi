package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AnketDto {

    private Long Id;
    private String anketName;
    private List<SoruDto> sorular;


}
