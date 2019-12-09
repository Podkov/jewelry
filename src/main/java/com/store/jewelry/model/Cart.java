package com.store.jewelry.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_order_id")
    private ClientOrder clientOrder;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "cart_bracelet",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "bracelet_id")
    )
    private List<Bracelet> bracelets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "cart_earrings",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "earrings_id")
    )
    private List<Earrings> earrings;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "cart_necklace",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "necklace_id")
    )
    private List<Necklace> necklaces;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "cart_ring",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "ring_id")
    )
    private List<Ring> rings;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }
}
