package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.AnketDto;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.CevapDto;
import com.bitpixeled.ankettoplamamerkezi.v1.service.CevapService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CevapController {

    private CevapService cevapService;

    public CevapController(CevapService cevapService) {
        this.cevapService = cevapService;
    }

    @GetMapping
    public List<CevapDto> findAll(){
        return cevapService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CevapDto addCevap (@RequestBody CevapDto cevap){
        return cevapService.addCevap(cevap);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CevapDto findCevapById (@PathVariable Long id){
        return cevapService.findCevapById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CevapDto updateCevapById(@PathVariable Long id, @RequestBody CevapDto cevap){
        return cevapService.updateCevapById(id, cevap);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCevapById(@PathVariable Long id){
        cevapService.deleteCevapById(id);
    }
}
