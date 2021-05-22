package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.CevapConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.CevapDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Cevap;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.CevapRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CevapService {

    private final CevapRepo cevapRepo;
    private final CevapConverter cevapConverter;

    public CevapService(CevapRepo cevapRepo, CevapConverter cevapConverter) {
        this.cevapRepo = cevapRepo;
        this.cevapConverter = cevapConverter;
    }

    public List<CevapDto> findAll() {
        return cevapConverter.createFromEntities(cevapRepo.findAll());
    }

    public CevapDto addCevap(CevapDto cevap) {
        return cevapConverter.fromEntity(cevapRepo.save(cevapConverter.fromDto(cevap)));
    }

    public CevapDto findCevapById(Long id) {
        return cevapConverter.fromEntity(cevapRepo.findById(id).orElseThrow(RecordNotFound::new));
    }

    public CevapDto updateCevapById(Long id, CevapDto cevap) {
        Cevap entity = cevapConverter.fromDto(findCevapById(id));
        return cevapConverter.fromEntity(cevapRepo.save(cevapConverter.updateEntity(entity, cevap)));
    }

    public void deleteCevapById(Long id) {
        cevapRepo.findById(id).ifPresentOrElse(cevapRepo::delete, RecordNotFound::new);
    }
}
