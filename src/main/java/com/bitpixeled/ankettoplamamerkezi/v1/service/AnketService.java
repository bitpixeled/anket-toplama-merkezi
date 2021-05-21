package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.AnketConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.converter.SoruConverter;
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
    private final AnketConverter anketConverter;
    private final SoruRepo soruRepo;
    private final SoruConverter soruConverter;

    public AnketService(AnketRepo anketRepo, AnketConverter anketConverter, SoruRepo soruRepo, SoruConverter soruConverter) {
        this.anketRepo = anketRepo;
        this.anketConverter = anketConverter;
        this.soruRepo = soruRepo;
        this.soruConverter = soruConverter;
    }

    public List<AnketDto> findAll (){
        return anketConverter.createFromEntities(anketRepo.findAll());
    }

    public AnketDto addAnket(AnketDto anketDto){
//        anketDto.getSorular().forEach((e) -> soruRepo.save(soruConverter.fromDto(e)));
        return anketConverter.fromEntity(anketRepo.save(anketConverter.fromDto(anketDto)));
    }

    public AnketDto findAnketById (Long id){
        return anketRepo.findById(id)
                .map(anketConverter::fromEntity)
                .orElseThrow(RecordNotFound::new);
    }

    public AnketDto updateAnketById(Long id, AnketDto anketDto){
        Anket anket = anketConverter.fromDto(findAnketById(id));
        return anketConverter.fromEntity(anketRepo.save(anketConverter.updateEntity(anket, anketDto)));
    }

    public void deleteAnketById(Long id){
        anketRepo.findById(id).ifPresentOrElse(anketRepo::delete, RecordNotFound::new);
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
