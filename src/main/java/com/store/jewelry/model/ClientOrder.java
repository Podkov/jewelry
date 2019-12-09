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

    //TODO many to many
//    private List<Client> clients;

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

}
