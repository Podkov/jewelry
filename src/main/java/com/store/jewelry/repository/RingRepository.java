package com.store.jewelry.repository;

import com.store.jewelry.model.Ring;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RingRepository extends CrudRepository<Ring, Long> {
}
