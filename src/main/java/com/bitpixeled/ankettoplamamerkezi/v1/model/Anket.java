package com.bitpixeled.ankettoplamamerkezi.v1.model;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class Anket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anketId;
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
