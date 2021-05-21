package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketorDto;
import com.bitpixeled.ankettoplamamerkezi.v1.service.AnketorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/anketorler")
public class AnketorController {

    private final AnketorService anketorService;

    public AnketorController(AnketorService anketorService) {
        this.anketorService = anketorService;
    }

    @GetMapping
    public List<AnketorDto> findAll() {
        return anketorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnketorDto addAnketor(@RequestBody AnketorDto anket) {
        return anketorService.addAnketor(anket);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnketorDto findAnketorById(@PathVariable Long id) {
        return anketorService.findAnketorById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnketorDto updateAnketorById(@PathVariable Long id, @RequestBody AnketorDto anket) {
        return anketorService.updateAnketorById(id, anket);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnketorById(@PathVariable Long id) {
        anketorService.deleteAnketorById(id);
    }
}
