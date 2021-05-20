package com.bitpixeled.ankettoplamamerkezi.v1.repository;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoruRepo extends JpaRepository<Soru, Long> {
}
