package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnketDto {

    private String name;
    private List<String> sorular;

}
