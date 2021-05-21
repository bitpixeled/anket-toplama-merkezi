package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.KatilimciConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.KatilimciDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.KatilimciRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KatilimciService {

    private final KatilimciRepo katilimciRepo;
    private final KatilimciConverter katilimciConverter;

    public KatilimciService(KatilimciRepo katilimciRepo, KatilimciConverter katilimciConverter) {
        this.katilimciRepo = katilimciRepo;
        this.katilimciConverter = katilimciConverter;
    }

    public List<KatilimciDto> findAll() {
        return katilimciConverter.createFromEntities(katilimciRepo.findAll());
    }

    public KatilimciDto addKatilimci(KatilimciDto katilimci) {
        return katilimciConverter.fromEntity(katilimciRepo.save(katilimciConverter.fromDto(katilimci)));
    }

    public KatilimciDto findKatilimciById(Long id) {
        return katilimciRepo.findById(id)
                .map(katilimciConverter::fromEntity)
                .orElseThrow(RecordNotFound::new);
    }

    public KatilimciDto updateKatilimciById(Long id, KatilimciDto katilimci) {
        return katilimciConverter.fromEntity
                (katilimciConverter.updateEntity
                        (katilimciRepo.findById(id).orElseThrow(RecordNotFound::new), katilimci));
    }

    public void deleteKatilimciById(Long id) {
        katilimciRepo.findById(id).ifPresentOrElse(katilimciRepo::delete, RecordNotFound::new);
    }
}
