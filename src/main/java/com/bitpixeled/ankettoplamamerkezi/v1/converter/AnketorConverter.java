package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketorDto;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anketor;
import org.springframework.stereotype.Component;

@Component
public class AnketorConverter implements GenericConverter <Anketor, AnketorDto>{

    @Override
    public Anketor fromDto(AnketorDto dto) {
        Anketor entity = new Anketor();
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        return entity;
    }

    @Override
    public AnketorDto fromEntity(Anketor entity) {
        AnketorDto dto = new AnketorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    @Override
    public Anketor updateEntity(Anketor entity, AnketorDto dto) {
        entity.setId(dto.getId()); //TODO check if ids match
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}
