package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import com.bitpixeled.ankettoplamamerkezi.v1.service.AnketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/anketler")
public class AnketController {

    private final AnketService anketService;

    public AnketController(AnketService anketService) {
        this.anketService = anketService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Anket addAnket (@RequestBody Anket anket){
       return anketService.addAnket(anket);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Anket findAnketById (@PathVariable Long id){
        return anketService.findAnketById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Anket updateAnketById(@PathVariable Long id, @RequestBody Anket anket){
        return anketService.updateAnketById(id, anket);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnketById(@PathVariable Long id){
        anketService.deleteAnketById(id);
    }

    @PostMapping(value = "/full")
    public Anket createWithDto(@RequestBody AnketDto anketDto){
        return anketService.createWithDto(anketDto);
    }

}
