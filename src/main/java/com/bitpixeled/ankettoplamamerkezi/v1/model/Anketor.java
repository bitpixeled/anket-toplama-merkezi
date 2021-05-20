package com.bitpixeled.ankettoplamamerkezi.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Anketor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anketorId;
    private String name;
    private String lastName;
}
