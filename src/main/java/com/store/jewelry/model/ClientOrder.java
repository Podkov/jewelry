package com.store.jewelry.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private LocalDate dateOfOrder;

    @Column
    private String orderStatus;

    @Column
    private float price;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_order_join",
            joinColumns = @JoinColumn(name = "client_order_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    @OneToOne(mappedBy = "clientOrder", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
