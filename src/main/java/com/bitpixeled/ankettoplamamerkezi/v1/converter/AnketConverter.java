package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.SoruDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.IdDidNotMatch;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import org.springframework.stereotype.Component;

import java.util.List;

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
        //----------
        Anket saved = anketRepo.save(entity);
        List<SoruDto> sorular = dto.getSorular();
        for (SoruDto soruDto : sorular) {
            soruDto.setAnketId(saved.getId());
        }
        //----------
        entity.setSorular(soruConverter.createFromDtos(sorular));
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
        if (!entity.getId().equals(dto.getId())) {
            throw new IdDidNotMatch(entity.getId(), dto.getId());
        }
        entity.setAnketName(dto.getAnketName());
        entity.setSorular(soruConverter.createFromDtos(dto.getSorular()));
        return entity;
    }
}
