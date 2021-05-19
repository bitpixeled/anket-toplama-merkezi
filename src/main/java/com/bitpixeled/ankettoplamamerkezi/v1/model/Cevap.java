package com.bitpixeled.ankettoplamamerkezi.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Cevap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cevap;

    @ManyToOne(fetch = FetchType.LAZY)
    private Anket anket;
    @ManyToOne(fetch = FetchType.LAZY)
    private Soru soru;
    @ManyToOne(fetch = FetchType.LAZY)
    private Katilimci katilimci;

}
