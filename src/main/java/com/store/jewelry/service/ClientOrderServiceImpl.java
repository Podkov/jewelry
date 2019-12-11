package com.store.jewelry.service;

import com.store.jewelry.model.Cart;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.ClientOrder;
import com.store.jewelry.repository.CartRepository;
import com.store.jewelry.repository.ClientOrderRepository;
import com.store.jewelry.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CartRepository cartRepository;

    public ClientOrderServiceImpl(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    @Override
    @Transactional
    public Long createClientOrder(LocalDate dateOfOrder, String orderStatus, float price, Long clientId) {

        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setDateOfOrder(LocalDate.now());
        clientOrder.setOrderStatus(orderStatus);
        clientOrder.setPrice(price);
        clientOrder.setClientId(clientId);
        Client client = clientRepository.findById(clientId).get();
        clientOrder.setClient(client);
        clientOrder.setCart(client.getCart());
        //Optional<Client> clientOptional = clientRepository.findById(clientId);
//        if (clientRepository.findById(clientId).isPresent()) {
//            clientOrder.setClient(clientRepository.findById(clientId).get());
//            if (clientRepository.findById(clientId).get().getCart()!=null) {
//                clientOrder.setCart(clientRepository.findById(clientId).get().getCart());
//            }
//        }


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
    public void updateClientOrder(Long clientOrderId, LocalDate dateOfOrder, String orderStatus, float price, Long clientId) {
        Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findById(clientOrderId);
        if (!clientOrderOptional.isPresent()){
            throw new EntityNotFoundException("ClientOrder, id: " + clientOrderId);
        }

        ClientOrder clientOrder = clientOrderOptional.get();
        clientOrder.setOrderStatus(orderStatus);
        clientOrder.setPrice(price);
        clientOrder.setClientId(clientId);
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            clientOrder.setClient(clientOptional.get());
            if (clientOptional.get().getCart()!=null) {
                clientOrder.setCart(clientOptional.get().getCart());
            }
        }

        clientOrderRepository.save(clientOrder);
    }

    @Override
    public Optional<ClientOrder> getClientOrder(Long clientOrderId) {
        return clientOrderRepository.findById(clientOrderId);
    }
}
