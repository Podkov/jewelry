package com.store.jewelry.service;

import com.store.jewelry.model.Address;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.ClientOrder;
import com.store.jewelry.model.Seller;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Long createClient(String firstName, String lastName, String nickName, String password, List<Address> addressList);

    List<Client> getAllClients();

    void deleteClient(Long clientId);

    void updateClient(Long clientId, String firstName, String lastName, String nickName, String password, List<Address> addressList, List<ClientOrder> clientOrderList);

    Optional<Client> getClient(Long clientId);

}
