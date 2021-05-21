package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.KatilimciDto;
import com.bitpixeled.ankettoplamamerkezi.v1.service.KatilimciService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/katilimcilar")
public class KatilimciController {

    private final KatilimciService katilimciService;

    public KatilimciController(KatilimciService katilimciService) {
        this.katilimciService = katilimciService;
    }

    @GetMapping
    public List<KatilimciDto> findAll(){
        return katilimciService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KatilimciDto addKatilimci (@RequestBody KatilimciDto katilimci){
        return katilimciService.addKatilimci(katilimci);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public KatilimciDto findKatilimciById (@PathVariable Long id){
        return katilimciService.findKatilimciById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public KatilimciDto updateKatilimciById(@PathVariable Long id, @RequestBody KatilimciDto katilimci){
        return katilimciService.updateKatilimciById(id, katilimci);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKatilimciById(@PathVariable Long id){
        katilimciService.deleteKatilimciById(id);
    }
}
