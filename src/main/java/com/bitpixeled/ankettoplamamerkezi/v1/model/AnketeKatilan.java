package com.bitpixeled.ankettoplamamerkezi.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnketeKatilan {

    private String adi;
    private String soyAdi;
    private Cinsiyet cinsiyet;
    private LocalDate dogumTarihi;
}
