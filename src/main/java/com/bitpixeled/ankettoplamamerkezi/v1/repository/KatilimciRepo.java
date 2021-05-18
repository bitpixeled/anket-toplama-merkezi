package com.bitpixeled.ankettoplamamerkezi.v1.repository;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Katilimci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KatilimciRepo extends CrudRepository<Katilimci, Long> {
}
