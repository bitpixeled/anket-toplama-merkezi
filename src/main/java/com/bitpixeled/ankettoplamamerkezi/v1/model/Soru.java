package com.bitpixeled.ankettoplamamerkezi.v1.model;

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
    private String aciklama;
    private Long anketId;
}