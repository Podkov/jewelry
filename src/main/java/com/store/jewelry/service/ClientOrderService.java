package com.store.jewelry.service;

import com.store.jewelry.model.Admin;
import com.store.jewelry.model.Cart;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.ClientOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientOrderService {

    Long createClientOrder(LocalDate dateOfOrder, String orderStatus, float price, Long clientId);

    List<ClientOrder> getAllClientOrders();

    void deleteClientOrder(Long clientOrderId);

    void updateClientOrder(Long clientOrderId, LocalDate dateOfOrder, String orderStatus, float price, Long clientId);

    Optional<ClientOrder> getClientOrder(Long clientOrderId);
}
