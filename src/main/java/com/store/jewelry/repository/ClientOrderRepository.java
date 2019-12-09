package com.store.jewelry.repository;

import com.store.jewelry.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends CrudRepository<ClientOrder, Long> {
}
