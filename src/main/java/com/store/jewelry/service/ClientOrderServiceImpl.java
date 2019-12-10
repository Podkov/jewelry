package com.store.jewelry.service;

import com.store.jewelry.model.Cart;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.ClientOrder;
import com.store.jewelry.repository.ClientOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientOrderServiceImpl implements ClientOrderService {

    private ClientOrderRepository clientOrderRepository;

    public ClientOrderServiceImpl(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    @Override
    @Transactional
    public Long createClientOrder(LocalDate dateOfOrder, String orderStatus, float price, List<Client> clientList, Cart cart) {

        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setDateOfOrder(dateOfOrder);
        clientOrder.setOrderStatus(orderStatus);
        clientOrder.setPrice(price);
        clientOrder.setClients(clientList);
        clientOrder.setCart(cart);

        clientOrderRepository.save(clientOrder);

        return clientOrder.getId();
    }

    @Override
    public List<ClientOrder> getAllClientOrders() {
        List<ClientOrder> clientOrders = new ArrayList<>();
        for (ClientOrder clientOrder: clientOrderRepository.findAll()){
            clientOrders.add(clientOrder);
        }

        return clientOrders;
    }

    @Override
    @Transactional
    public void deleteClientOrder(Long clientOrderId) {
        clientOrderRepository.deleteById(clientOrderId);
    }

    @Override
    @Transactional
    public void updateClientOrder(Long clientOrderId, LocalDate dateOfOrder, String orderStatus, float price, List<Client> clientList, Cart cart) {
        Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findById(clientOrderId);
        if (!clientOrderOptional.isPresent()){
            throw new EntityNotFoundException("ClientOrder, id: " + clientOrderId);
        }

        ClientOrder clientOrder = clientOrderOptional.get();
        clientOrder.setDateOfOrder(dateOfOrder);
        clientOrder.setOrderStatus(orderStatus);
        clientOrder.setPrice(price);
        clientOrder.setClients(clientList);
        clientOrder.setCart(cart);

        clientOrderRepository.save(clientOrder);
    }
}
