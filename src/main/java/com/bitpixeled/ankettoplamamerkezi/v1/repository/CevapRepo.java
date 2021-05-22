package com.bitpixeled.ankettoplamamerkezi.v1.repository;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Cevap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CevapRepo extends JpaRepository<Cevap, Long> {

    @Query(value = "select c from Cevap c where c.anket.id =:id")
    List<Cevap> findByAnketId(Long id);
    @Query(value = "select c from Cevap c where c.soru.id =:id")
    List<Cevap> findBySoruId(Long id);
}
