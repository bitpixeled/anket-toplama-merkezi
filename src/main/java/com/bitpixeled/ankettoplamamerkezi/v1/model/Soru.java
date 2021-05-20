package com.bitpixeled.ankettoplamamerkezi.v1.model;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.SoruDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Soru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long soruId;
    private String soru;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anket", referencedColumnName = "anketId")
    private Anket anket;



}
