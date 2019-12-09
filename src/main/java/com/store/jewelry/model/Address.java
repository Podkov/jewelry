package com.store.jewelry.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private int zipCode;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String apartmentNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_address",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
