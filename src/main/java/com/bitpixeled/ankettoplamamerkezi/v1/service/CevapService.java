package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.CevapConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.dto.CevapDto;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.CevapRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CevapService {

    private final CevapRepo cevapRepo;
    private final CevapConverter cevapConverter;

    public CevapService(CevapRepo cevapRepo, CevapConverter cevapConverter) {
        this.cevapRepo = cevapRepo;
        this.cevapConverter = cevapConverter;
    }

    public List<CevapDto> findAll() {
        return null;
    }

    public CevapDto addCevap(CevapDto cevap) {
        return null;
    }

    public CevapDto findCevapById(Long id) {
        return null;
    }

    public CevapDto updateCevapById(Long id, CevapDto cevap) {
        return null;
    }

    public void deleteCevapById(Long id) {

    }
}
