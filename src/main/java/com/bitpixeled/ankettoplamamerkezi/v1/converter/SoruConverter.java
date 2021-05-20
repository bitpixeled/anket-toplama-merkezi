package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.SoruDto;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import org.springframework.stereotype.Component;

@Component
public class SoruConverter implements GenericConverter <Soru, SoruDto>{
    @Override
    public Soru fromDto(SoruDto dto) {
        Soru entity = new Soru();
        entity.setSoru(dto.getSoru());
        return entity;
    }

    @Override
    public SoruDto fromEntity(Soru entity) {
        SoruDto dto = new SoruDto();
        dto.setSoru(entity.getSoru());
        dto.setSoruId(entity.getSoruId());
        return dto;
    }
}
