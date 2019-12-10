package com.store.jewelry.service;

import com.store.jewelry.model.Address;
import com.store.jewelry.model.Client;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Long createAddress(int zipCode, String street, String houseNumber, String apartmentNumber, List<Client> clientList);

    List<Address> getAllAddresses();

    void deleteAddress(Long addressId);

    void updateAddress(Long addressId, int zipCode, String street, String houseNumber, String apartmentNumber, List<Client> clientList);

    Optional<Address> getAddress(Long addressId);

}
