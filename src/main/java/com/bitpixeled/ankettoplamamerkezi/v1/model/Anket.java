package com.bitpixeled.ankettoplamamerkezi.v1.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Anket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String anketName;

    @OneToMany(mappedBy = "anket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Soru> sorular = new ArrayList<>();

    public Anket(String name) {
        this.anketName = name;
    }

    public void addSoru(Soru soru) {
        sorular.add(soru);
        soru.setAnket(this);
    }

    public void removeSoru(Soru soru) {
        sorular.remove(soru);
        soru.setAnket(null);
    }
}
