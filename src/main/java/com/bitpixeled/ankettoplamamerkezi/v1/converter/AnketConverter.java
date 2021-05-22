package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import org.springframework.stereotype.Component;

@Component
public class AnketConverter implements GenericConverter <Anket, AnketDto>{

    private final SoruConverter soruConverter;
    private final AnketRepo anketRepo;

    public AnketConverter(SoruConverter soruConverter, AnketRepo anketRepo) {
        this.soruConverter = soruConverter;
        this.anketRepo = anketRepo;
    }


    @Override
    public Anket fromDto(AnketDto dto) {
        Anket entity = new Anket();
        entity.setId(dto.getId());
        entity.setAnketName(dto.getAnketName());
        anketRepo.save(entity); //
        entity.setSorular(soruConverter.createFromDtos(dto.getSorular()));
        return entity;
    }

    @Override
    public AnketDto fromEntity(Anket entity) {
        AnketDto anketDto = new AnketDto();
        anketDto.setId(entity.getId());
        anketDto.setAnketName(entity.getAnketName());
        anketDto.setSorular(soruConverter.createFromEntities(entity.getSorular()));
        return anketDto;
    }

    @Override
    public Anket updateEntity(Anket entity, AnketDto dto) {
        entity.setId(dto.getId());
        entity.setAnketName(dto.getAnketName());
        entity.setSorular(soruConverter.createFromDtos(dto.getSorular()));
        return entity;
    }
}
