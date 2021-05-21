package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.KatilimciDto;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Katilimci;
import org.springframework.stereotype.Component;

@Component
public class KatilimciConverter implements GenericConverter <Katilimci, KatilimciDto>{

    @Override
    public Katilimci fromDto(KatilimciDto dto) {
        Katilimci entity = new Katilimci();
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setGender(dto.getGender());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }

    @Override
    public KatilimciDto fromEntity(Katilimci entity) {
        KatilimciDto dto = new KatilimciDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        dto.setGender(entity.getGender());
        dto.setBirthDate(entity.getBirthDate());
        return dto;
    }

    @Override
    public Katilimci updateEntity(Katilimci entity, KatilimciDto dto) {
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setGender(dto.getGender());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }
}
