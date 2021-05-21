package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.dto.SoruDto;
import com.bitpixeled.ankettoplamamerkezi.v1.service.SoruService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sorular")
public class SoruController {

    private final SoruService soruService;

    public SoruController(SoruService soruService) {
        this.soruService = soruService;
    }

    @GetMapping
    public List<SoruDto> findAll() {
        return soruService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoruDto addSoru(@RequestBody SoruDto soru) {
        return soruService.addSoru(soru);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SoruDto findSoruById(@PathVariable Long id) {
        return soruService.findSoruById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SoruDto updateSoruById(@PathVariable Long id, @RequestBody SoruDto soru) {
        return soruService.updateSoruById(id, soru);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoruById(@PathVariable Long id) {
        soruService.deleteSoruById(id);
    }
}
