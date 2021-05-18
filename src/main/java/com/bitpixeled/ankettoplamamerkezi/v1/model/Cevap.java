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
    private String answer;
    private Long anketId;
    private Long soruId;
    private Long katilimciId;


}
