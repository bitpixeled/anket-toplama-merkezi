package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Anketor;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnketorController {

    @Autowired
    private AnketorRepo anketorRepo;

    @PostMapping(value = "/anketor")
    public ResponseEntity<String> createAnketor (@RequestBody Anketor anketor){
        anketorRepo.save(anketor);
        return ResponseEntity.status(HttpStatus.OK).body("Created "+anketor);
    }
}
