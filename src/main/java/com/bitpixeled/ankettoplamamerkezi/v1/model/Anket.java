package com.bitpixeled.ankettoplamamerkezi.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Anket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String anketAdi;
//    @ElementCollection()
//    private List<Long> sorular;
}
