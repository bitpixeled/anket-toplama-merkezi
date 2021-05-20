package com.bitpixeled.ankettoplamamerkezi.v1.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Katilimci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long katilimciId;
    private String name;
    private String lastName;
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Gender gender;
    private LocalDate birthDate;
}
