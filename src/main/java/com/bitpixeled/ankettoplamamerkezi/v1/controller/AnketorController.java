package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anketor;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/anketorler")
public class AnketorController {

    private final AnketorRepo anketorRepo;

    public AnketorController(AnketorRepo anketorRepo) {
        this.anketorRepo = anketorRepo;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Anketor addAnketor (@RequestBody Anketor anketor){
        return anketorRepo.save(anketor);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Anketor getAnketorById (@PathVariable Long id){
        return anketorRepo.findById(id).orElseThrow(RecordNotFound::new);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Anketor updateAnketorById (@PathVariable Long id, @RequestBody Anketor anketor){
            Anketor entity = anketorRepo.findById(id).orElseThrow(RecordNotFound::new);
            entity.setName(anketor.getName());
            entity.setLastName(anketor.getLastName());
            return anketorRepo.save(entity);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnketorById(@PathVariable Long id){
        anketorRepo.deleteById(id);
    }
}
