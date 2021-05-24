package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.service.AnketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/anketler")
public class AnketController {

    private final AnketService anketService;

    public AnketController(AnketService anketService) {
        this.anketService = anketService;
    }

    @GetMapping
    public List<AnketDto> findAll(){
        return anketService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnketDto addAnket (@RequestBody AnketDto anket){
       return anketService.addAnket(anket);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnketDto findAnketById (@PathVariable Long id){
        return anketService.findAnketById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnketDto updateAnketById(@PathVariable Long id, @RequestBody AnketDto anket){
        return anketService.updateAnketById(id, anket);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnketById(@PathVariable Long id){
        anketService.deleteAnketById(id);
    }

}
