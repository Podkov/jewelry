package com.store.jewelry.model;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    private Product product;




}
