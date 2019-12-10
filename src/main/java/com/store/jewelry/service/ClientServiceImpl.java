package com.store.jewelry.service;

import com.store.jewelry.model.Address;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.ClientOrder;
import com.store.jewelry.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public Long createClient(String firstName, String lastName, String nickName, String password, List<Address> addressList) {

        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setNickName(nickName);
        client.setPassword(password);
        client.setAddresses(addressList); //pierwotnie pusta lista - dodanie adresu dodaje do listy

        clientRepository.save(client);

        return client.getId();
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        for (Client client: clientRepository.findAll()){
            clients.add(client);
        }
        return clients;
    }

    @Override
    @Transactional
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    @Transactional
    public void updateClient(Long clientId, String firstName, String lastName, String nickName, String password, List<Address> addressList, List<ClientOrder> clientOrderList) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (!clientOptional.isPresent()){
            throw new EntityNotFoundException("Client, id: " + clientId);
        }

        Client client = clientOptional.get();
        client.setFirstName(nickName);
        client.setLastName(lastName);
        client.setNickName(nickName);
        client.setPassword(password);
        client.setAddresses(addressList);
        client.setClientOrders(clientOrderList);

        clientRepository.save(client);
    }
}
