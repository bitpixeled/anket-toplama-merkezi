package com.bitpixeled.ankettoplamamerkezi.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Soru {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String soruAdi;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Anket anket;

    public Soru(String soru) {
        this.soruAdi = soru;
    }


    public Soru(String soru, Anket anket) {
        this.soruAdi = soru;
        this.anket = anket;
    }
}
