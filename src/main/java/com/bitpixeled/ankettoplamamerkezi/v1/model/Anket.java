package com.bitpixeled.ankettoplamamerkezi.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Anket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String anketAdi;
    @ElementCollection()
    private List<Long> sorular;
}
