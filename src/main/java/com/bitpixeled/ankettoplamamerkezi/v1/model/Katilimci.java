package com.bitpixeled.ankettoplamamerkezi.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Katilimci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Gender gender;
    private LocalDate birthDate;
}
