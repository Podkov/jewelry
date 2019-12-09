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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_order_bracelet",
            joinColumns = @JoinColumn(name = "client_order_id"),
            inverseJoinColumns = @JoinColumn(name = "bracelet_id")
    )
    private List<Bracelet> bracelets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_order_earrings",
            joinColumns = @JoinColumn(name = "client_order_id"),
            inverseJoinColumns = @JoinColumn(name = "earrings_id")
    )
    private List<Earrings> earrings;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_order_necklace",
            joinColumns = @JoinColumn(name = "client_order_id"),
            inverseJoinColumns = @JoinColumn(name = "necklace_id")
    )
    private List<Necklace> necklaces;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_order_ring",
            joinColumns = @JoinColumn(name = "client_order_id"),
            inverseJoinColumns = @JoinColumn(name = "ring_id")
    )
    private List<Ring> rings;

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

    public List<Bracelet> getBracelets() {
        return bracelets;
    }

    public void setBracelets(List<Bracelet> bracelets) {
        this.bracelets = bracelets;
    }

    public List<Earrings> getEarrings() {
        return earrings;
    }

    public void setEarrings(List<Earrings> earrings) {
        this.earrings = earrings;
    }

    public List<Necklace> getNecklaces() {
        return necklaces;
    }

    public void setNecklaces(List<Necklace> necklaces) {
        this.necklaces = necklaces;
    }

    public List<Ring> getRings() {
        return rings;
    }

    public void setRings(List<Ring> rings) {
        this.rings = rings;
    }
}
