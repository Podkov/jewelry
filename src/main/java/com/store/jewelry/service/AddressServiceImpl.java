package com.store.jewelry.service;

import com.store.jewelry.model.Address;
import com.store.jewelry.model.Client;
import com.store.jewelry.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public Long createAddress(int zipCode, String street, String houseNumber, String apartmentNumber, List<Client> clientList) {

        Address address = new Address();
        address.setZipCode(zipCode);
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
        address.setApartmentNumber(apartmentNumber);
        address.setClients(clientList);

        addressRepository.save(address);

        return address.getId();
    }

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<>();

        for (Address address: addressRepository.findAll()){
            addresses.add(address);
        }

        return addresses;
    }

    @Override
    @Transactional
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    @Transactional
    public void updateAddress(Long addressId, int zipCode, String street, String houseNumber, String apartmentNumber, List<Client> clientList) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        if (!addressOptional.isPresent()){
            throw new EntityNotFoundException("Address, id: " + addressId);
        }

        Address address = addressOptional.get();
        address.setZipCode(zipCode);
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
        address.setApartmentNumber(apartmentNumber);
        address.setClients(clientList);

        addressRepository.save(address);
    }
}
