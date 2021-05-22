package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.AnketConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnketService {

    private final AnketRepo anketRepo;
    private final AnketConverter anketConverter;

    public AnketService(AnketRepo anketRepo, AnketConverter anketConverter) {
        this.anketRepo = anketRepo;
        this.anketConverter = anketConverter;
    }

    public List<AnketDto> findAll (){
        return anketConverter.createFromEntities(anketRepo.findAll());
    }

    public AnketDto addAnket(AnketDto anketDto){
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
}
