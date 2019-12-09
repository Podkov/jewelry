package com.store.jewelry.repository;

import com.store.jewelry.model.Earrings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarringsRepository extends CrudRepository<Earrings, Long> {
}
