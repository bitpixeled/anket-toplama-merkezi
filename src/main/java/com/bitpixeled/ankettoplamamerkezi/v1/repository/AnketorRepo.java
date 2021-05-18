package com.bitpixeled.ankettoplamamerkezi.v1.repository;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Anketor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnketorRepo extends CrudRepository<Anketor, Long> {
}
