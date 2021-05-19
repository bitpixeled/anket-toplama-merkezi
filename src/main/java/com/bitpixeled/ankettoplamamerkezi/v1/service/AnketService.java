package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.SoruRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnketService {

    private final AnketRepo anketRepo;
    private final SoruRepo soruRepo;

    public AnketService(AnketRepo anketRepo, SoruRepo soruRepo) {
        this.anketRepo = anketRepo;
        this.soruRepo = soruRepo;
    }

    public Anket addAnket (Anket anket){
        return anketRepo.save(anket);
    }

    public Anket findAnketById (Long id){
        return anketRepo.findById(id).orElseThrow(RecordNotFound::new);
    }

    public Anket updateAnketById(Long id, Anket anket){
        Anket record = anketRepo.findById(id).orElseThrow(RecordNotFound::new);
        record.setAnketAdi(anket.getAnketAdi());
        return anketRepo.save(record);
    }

    public void deleteAnketById(Long id){
        anketRepo.deleteById(id);
    }

    public Anket createWithDto (AnketDto anketDto){
        Anket anket = anketRepo.save(new Anket(anketDto.getAnketName()));
        List<String> sorular = anketDto.getSorular();
        for (String s : sorular) {
            Soru save = soruRepo.save(new Soru(s));
            anket.addSoru(save);
        }
        return anket;
    }
}
