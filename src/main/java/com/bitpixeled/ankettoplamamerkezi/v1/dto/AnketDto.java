package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnketDto {

    private String anketName;
    private List<String> sorular;

    public AnketDto() {
    }

    public AnketDto(String anketName, List<String> sorular) {
        this.anketName = anketName;
        this.sorular = sorular;
    }
}
