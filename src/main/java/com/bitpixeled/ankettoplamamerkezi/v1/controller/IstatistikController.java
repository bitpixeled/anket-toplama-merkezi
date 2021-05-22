package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.service.IstatistikService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/istatistikler")
public class IstatistikController {

    private final IstatistikService istatistikService;

    public IstatistikController(IstatistikService istatistikService) {
        this.istatistikService = istatistikService;
    }

    @GetMapping
    public Object anketIstatistikleri (@RequestParam Long anketId){
        return istatistikService.getIstatistikById(anketId);
    }
}
