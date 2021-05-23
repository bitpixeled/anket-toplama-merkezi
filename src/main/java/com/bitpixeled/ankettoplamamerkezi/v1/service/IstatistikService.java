package com.bitpixeled.ankettoplamamerkezi.v1.service;

import com.bitpixeled.ankettoplamamerkezi.v1.converter.AnketConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.converter.CevapConverter;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Anket;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Cevap;
import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.AnketRepo;
import com.bitpixeled.ankettoplamamerkezi.v1.repository.CevapRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IstatistikService {

    private final CevapRepo cevapRepo;
    private final CevapConverter cevapConverter;
    private final AnketRepo anketRepo;
//    private final AnketConverter anketConverter;

    public IstatistikService(CevapRepo cevapRepo, CevapConverter cevapConverter, AnketRepo anketRepo) {
        this.cevapRepo = cevapRepo;
        this.cevapConverter = cevapConverter;
        this.anketRepo = anketRepo;
    }

    public Object getIstatistikById(Long anketId) {
        Anket anket = anketRepo.findById(anketId).orElseThrow(RecordNotFound::new);
        List<Soru> sorular = anket.getSorular();
        Map<Soru, Map<String, Double>> istMap = new HashMap<>();

        for (Soru soru : sorular) {
            Map<String, Double> istatistik = new HashMap<>();
            List<Cevap> cevaplar = cevapRepo.findBySoruId(soru.getId());
            Map<String, Integer> map = new HashMap<>();
            int total = cevaplar.size();
            if(soru.isNumeric()){
                double toplamDeger = 0;
                for (Cevap cevap : cevaplar) {
                    int integer = Integer.parseInt(cevap.getCevap());
                    toplamDeger += integer;
                }
                double ortalama = toplamDeger/total*10;
                istatistik.put(soru.getSoru(), ortalama);
            }
            else {
                for (Cevap cevap : cevaplar) {
                    if(map.containsKey(cevap.getCevap())){
                        Integer value = map.get(cevap.getCevap())+1;
                        map.put(cevap.getCevap(), value);
                    } else {
                        map.put(cevap.getCevap(), 1);
                    }
                }
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    istatistik.put(entry.getKey(), entry.getValue().doubleValue()/total*100.0);
                }
            }
            istMap.put(soru, istatistik);
        }
        return istMap;
    }
}
