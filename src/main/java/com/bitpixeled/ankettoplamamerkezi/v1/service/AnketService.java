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
import java.util.stream.Collectors;

@Service
@Transactional
public class AnketService {

    private final AnketRepo anketRepo;
    private final SoruRepo soruRepo;

    public AnketService(AnketRepo anketRepo, SoruRepo soruRepo) {
        this.anketRepo = anketRepo;
        this.soruRepo = soruRepo;
    }

    public List<AnketDto> findAll (){
        return anketRepo.findAll().stream().map(AnketDto::new).collect(Collectors.toList());
    }

    public AnketDto addAnket(AnketDto anketDto){
        Anket anket = anketRepo.save(anketDto.toEntity(anketDto));
        return anket.toDto(anket);
    }

    public AnketDto findAnketById (Long id){
        Anket anket = anketRepo.findById(id).orElseThrow(RecordNotFound::new);
        return anket.toDto(anket);
    }

    public AnketDto updateAnketById(Long id, AnketDto anketDto){
        Anket anket = anketRepo.findById(id).orElseThrow(RecordNotFound::new);
        anketRepo.save(anket);
        return anket.toDto(anket);
    }

    public void deleteAnketById(Long id){
        anketRepo.deleteById(id);
    }

//    public Anket createWithDto (AnketDto anketDto){
//        Anket anket = anketRepo.save(new Anket(anketDto.getAnketName()));
//        List<String> sorular = anketDto.getSorular();
//        for (String s : sorular) {
//            Soru save = soruRepo.save(new Soru(s));
//            anket.addSoru(save);
//        }
//        return anket;
//    }
}
