package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.CevapDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.OutOfRange;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.UnexpectedValue;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Cevap;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketorRepo;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.KatilimciRepo;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.SoruRepo;
import org.springframework.stereotype.Component;

@Component
public class CevapConverter implements GenericConverter <Cevap, CevapDto>{

    private final AnketorRepo anketorRepo;
    private final AnketRepo anketRepo;
    private final SoruRepo soruRepo;
    private final KatilimciRepo katilimciRepo;

    public CevapConverter(AnketorRepo anketorRepo, AnketRepo anketRepo, SoruRepo soruRepo, KatilimciRepo katilimciRepo) {
        this.anketorRepo = anketorRepo;
        this.anketRepo = anketRepo;
        this.soruRepo = soruRepo;
        this.katilimciRepo = katilimciRepo;
    }

    @Override
    public Cevap fromDto(CevapDto dto) {
        Soru soru = soruRepo.findById(dto.getSoruId()).orElseThrow(()-> new RecordNotFound("Soru bulunamadı"));
        if(soru.isNumeric()){
            validateNumberParsing(dto.getCevap());
        }
        Cevap entity = new Cevap();
        entity.setId(dto.getId());
        entity.setCevap(dto.getCevap());
        entity.setSoru(soruRepo.findById(dto.getSoruId()).orElseThrow(()-> new RecordNotFound("Soru bulunamadı")));
        entity.setAnket(anketRepo.findById(dto.getAnketId()).orElseThrow(()-> new RecordNotFound("Anket bulunamadı")));
        entity.setKatilimci(katilimciRepo.findById(dto.getKatilimciId()).orElseThrow(()-> new RecordNotFound("Katilimci Bulunamadı")));
        entity.setAnketor(anketorRepo.findById(dto.getAnketorId()).orElseThrow(()-> new RecordNotFound("Anketör bulunamadı")));
        return entity;
    }

    @Override
    public CevapDto fromEntity(Cevap entity) {
        CevapDto dto = new CevapDto();
        dto.setId(entity.getId());
        dto.setCevap(entity.getCevap());
        dto.setSoruId(entity.getSoru().getId());
        dto.setAnketId(entity.getAnket().getId());
        dto.setKatilimciId(entity.getKatilimci().getId());
        dto.setAnketorId(entity.getAnketor().getId());
        return dto;
    }

    @Override
    public Cevap updateEntity(Cevap entity, CevapDto dto) {
        entity.setId(dto.getId());
        entity.setCevap(dto.getCevap());
        entity.setSoru(soruRepo.findById(dto.getSoruId()).orElseThrow(()-> new RecordNotFound("Soru bulunamadı")));
        entity.setAnket(anketRepo.findById(dto.getAnketId()).orElseThrow(()-> new RecordNotFound("Anket bulunamadı")));
        entity.setKatilimci(katilimciRepo.findById(dto.getKatilimciId()).orElseThrow(()-> new RecordNotFound("Katilimci Bulunamadı")));
        entity.setAnketor(anketorRepo.findById(dto.getAnketorId()).orElseThrow(()-> new RecordNotFound("Anketör Bulunamadı")));
        return entity;
    }

    public void validateNumberParsing (String s) {
        try {
            int cevap = Integer.parseInt(s);
            if (!(cevap >= 0 && cevap <=10)){
                throw new OutOfRange(cevap);
            }
        } catch (Exception e){
            throw new UnexpectedValue(s);
        }

    }
}

