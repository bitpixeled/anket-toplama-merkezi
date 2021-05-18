package com.bitpixeled.ankettoplamamerkezi.v1.repository;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Cevap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CevapRepo extends CrudRepository<Cevap, Long> {
}
