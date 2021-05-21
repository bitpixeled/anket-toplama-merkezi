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
        entity.setNumericAnswerExpected(dto.isNumericAnswerExpected());
        return entity;
    }

    @Override
    public SoruDto fromEntity(Soru entity) {
        SoruDto dto = new SoruDto();
        dto.setId(entity.getId());
        dto.setSoru(entity.getSoru());
        dto.setNumericAnswerExpected(entity.isNumericAnswerExpected());
        return dto;
    }

    @Override
    public Soru updateEntity(Soru entity, SoruDto dto) {
        entity.setSoru(dto.getSoru());
        entity.setNumericAnswerExpected(dto.isNumericAnswerExpected());
        return entity;
    }
}
