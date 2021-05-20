package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SoruDto {

    private Long soruId;
    private String soru;

    public SoruDto(Soru soru) {
        this.soruId = soru.getSoruId();
        this.soru = soru.getSoru();
    }

    public SoruDto(Long soruId, String soru) {
        this.soruId = soruId;
        this.soru = soru;
    }
}
