package com.bitpixeled.ankettoplamamerkezi.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Katilimci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adi;
    private String soyAdi;
    private Cinsiyet cinsiyet;
    private LocalDate dogumTarihi;
}
