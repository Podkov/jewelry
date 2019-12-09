package com.store.jewelry.repository;

import com.store.jewelry.model.Necklace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecklaceRepository extends CrudRepository<Necklace, Long> {
}
