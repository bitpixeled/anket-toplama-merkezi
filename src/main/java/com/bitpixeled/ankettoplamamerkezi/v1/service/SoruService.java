package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.SoruConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.SoruDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.SoruRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoruService {

    private final SoruRepo soruRepo;
    private final SoruConverter soruConverter;

    public SoruService(SoruRepo soruRepo, SoruConverter soruConverter) {
        this.soruRepo = soruRepo;
        this.soruConverter = soruConverter;
    }

    public List<SoruDto> findAll() {
        return soruConverter.createFromEntities(soruRepo.findAll());
    }


    public SoruDto addSoru(SoruDto soru) {
        return soruConverter.fromEntity(soruRepo.save(soruConverter.fromDto(soru)));
    }


    public SoruDto findSoruById(Long id) {
        return soruConverter.fromEntity(soruRepo.findById(id).orElseThrow(RuntimeException::new));
    }


    public SoruDto updateSoruById(Long id, SoruDto soru) {
        Soru entity = soruConverter.fromDto(findSoruById(id));
        return soruConverter.fromEntity(soruRepo.save(soruConverter.updateEntity(entity, soru)));
    }


    public void deleteSoruById(Long id) {
        soruRepo.findById(id).ifPresentOrElse(soruRepo::delete, RecordNotFound::new);
    }
}
