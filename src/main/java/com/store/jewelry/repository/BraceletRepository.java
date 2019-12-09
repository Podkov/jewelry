package com.store.jewelry.repository;

import com.store.jewelry.model.Bracelet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BraceletRepository extends CrudRepository<Bracelet, Long> {

}
