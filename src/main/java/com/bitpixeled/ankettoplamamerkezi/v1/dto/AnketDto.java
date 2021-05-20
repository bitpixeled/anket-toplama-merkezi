package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class AnketDto {

    private Long anketId;
    private String anketName;
    private List<SoruDto> sorular;

    public AnketDto() {
    }

    public AnketDto(Anket anket) {
        this.anketId = anket.getAnketId();
        this.anketName = anket.getAnketName();
        this.sorular = anket.getSorular().stream().map(SoruDto::new).collect(Collectors.toList());
    }

    public Anket toEntity(AnketDto anketDto){
        return new Anket(anketDto);
    }
}
