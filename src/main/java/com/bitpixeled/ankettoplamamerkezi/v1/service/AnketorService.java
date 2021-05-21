package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.AnketorConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketorDto;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anketor;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnketorService {

    private final AnketorRepo anketorRepo;
    private final AnketorConverter anketorConverter;

    public AnketorService(AnketorRepo anketorRepo, AnketorConverter anketorConverter) {
        this.anketorRepo = anketorRepo;
        this.anketorConverter = anketorConverter;
    }

    public List<AnketorDto> findAll() {
        return anketorConverter.createFromEntities(anketorRepo.findAll());
    }

    public AnketorDto addAnketor(AnketorDto anket) {
        //TODO - id passed by dto to generated id could cause problem
        return anketorConverter.fromEntity(anketorRepo.save(anketorConverter.fromDto(anket)));
    }


    public AnketorDto findAnketorById(Long id) {
        return anketorConverter.fromEntity(anketorRepo.findById(id).orElseThrow(RecordNotFound::new));
    }

    public AnketorDto updateAnketorById(Long id, AnketorDto dto) {
        //TODO - id passed by dto to generated id could cause problem
        Anketor entity = anketorConverter.fromDto(findAnketorById(id));
        return anketorConverter.fromEntity(anketorRepo.save(anketorConverter.updateEntity(entity, dto)));
    }

    public void deleteAnketorById(Long id) {
        anketorRepo.findById(id).ifPresentOrElse(anketorRepo::delete, RecordNotFound::new);
    }
}
