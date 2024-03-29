package com.store.jewelry.service;

import com.store.jewelry.model.Address;
import com.store.jewelry.model.Client;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Long createAddress(String zipCode, String street, String houseNumber, String apartmentNumber, List<Client> clientList);

    List<Address> getAllAddresses();

    void deleteAddress(Long addressId);

    void updateAddress(Long addressId, String zipCode, String street, String houseNumber, String apartmentNumber, List<Client> clientList);

    Optional<Address> getAddress(Long addressId);

    List<Address> getAllAddresses(Long clientId);


}
