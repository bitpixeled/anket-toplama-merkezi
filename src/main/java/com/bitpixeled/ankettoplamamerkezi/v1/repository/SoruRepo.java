package com.bitpixeled.ankettoplamamerkezi.v1.repository;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Soru;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoruRepo extends CrudRepository<Soru, Long> {
}
