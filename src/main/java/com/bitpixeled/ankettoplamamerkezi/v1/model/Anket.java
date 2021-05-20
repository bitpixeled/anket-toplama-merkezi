package com.bitpixeled.ankettoplamamerkezi.v1.model;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
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

    public String getAnketName() {
        return anketName;
    }

    public void setAnketName(String anketName) {
        this.anketName = anketName;
    }

    public List<Soru> getSorular() {
        return sorular;
    }

    public void setSorular(List<Soru> sorular) {
        this.sorular = sorular;
    }

    public Long getAnketId() {
        return anketId;
    }

    public void setAnketId(Long anketId) {
        this.anketId = anketId;
    }

    public Anket(AnketDto anketDto) {
        this.anketName = anketDto.getAnketName();
        this.sorular = anketDto.getSorular().stream().map(Soru::new).collect(Collectors.toList());
    }

    public AnketDto toDto (Anket anket){
        return new AnketDto(anket);
    }
}
