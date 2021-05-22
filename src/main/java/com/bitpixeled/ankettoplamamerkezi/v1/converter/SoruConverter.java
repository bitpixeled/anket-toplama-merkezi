package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.SoruDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import org.springframework.stereotype.Component;

@Component
public class SoruConverter implements GenericConverter <Soru, SoruDto>{

    private final AnketRepo anketRepo;

    public SoruConverter(AnketRepo anketRepo) {
        this.anketRepo = anketRepo;
    }

    @Override
    public Soru fromDto(SoruDto dto) {
        Soru entity = new Soru();
        entity.setId(dto.getId());
        entity.setSoru(dto.getSoru());
        entity.setNumericAnswerExpected(dto.isNumericAnswerExpected());
        entity.setAnket(anketRepo.findById(dto.getAnketId()).orElseThrow(()-> new RecordNotFound("Anket bulunamadı")));
        return entity;
    }

    @Override
    public SoruDto fromEntity(Soru entity) {
        SoruDto dto = new SoruDto();
        dto.setId(entity.getId());
        dto.setSoru(entity.getSoru());
        dto.setNumericAnswerExpected(entity.isNumericAnswerExpected());
        dto.setAnketId(entity.getAnket().getId());
        return dto;
    }

    @Override
    public Soru updateEntity(Soru entity, SoruDto dto) {
        entity.setId(dto.getId());
        entity.setSoru(dto.getSoru());
        entity.setNumericAnswerExpected(dto.isNumericAnswerExpected());
        entity.setAnket(anketRepo.findById(dto.getAnketId()).orElseThrow(()-> new RecordNotFound("Anket bulunamadı")));
        return entity;
    }
}
