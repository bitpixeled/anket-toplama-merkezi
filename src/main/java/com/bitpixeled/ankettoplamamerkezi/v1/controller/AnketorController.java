package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Anketor;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/anketorler")
public class AnketorController {

    @Autowired
    private AnketorRepo anketorRepo;

    @PostMapping(value = "")
    public ResponseEntity<String> addAnketor (@RequestBody Anketor anketor){
        anketorRepo.save(anketor);
        return ResponseEntity.status(HttpStatus.OK).body("Yeni anketör "+anketor+" eklendi");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Anketor> getAnketorById (@PathVariable Long id){
        Anketor anketor = anketorRepo.findById(id).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(anketor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateAnketorById (@PathVariable Long id, @RequestBody Anketor anketor){
        Anketor entity = anketorRepo.findById(id).orElseThrow();
        entity.setName(anketor.getName());
        entity.setLastName(anketor.getLastName());
        anketorRepo.save(entity);
        return ResponseEntity.status(HttpStatus.OK).body("Güncelleme Islemi Basari ile Gerceklestirildi");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAnketorById(@PathVariable Long id){
        anketorRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Silme Islemi Basari ile Gerceklestirildi");
    }
}
