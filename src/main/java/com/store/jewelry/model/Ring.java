package com.store.jewelry.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ring extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private float price;

    @Column
    private String name;

    @Column
    private boolean withStone;

    @Column
    private double size;

    @Column
    private String materialType;

    @Column
    private boolean isRealDiamond;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "cart_ring",
            joinColumns = @JoinColumn(name = "ring_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private List<Cart> clientCarts;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public boolean isRealDiamond() {
        return isRealDiamond;
    }

    public void setRealDiamond(boolean realDiamond) {
        isRealDiamond = realDiamond;
    }

    public boolean isWithStone() {
        return withStone;
    }

    public void setWithStone(boolean withStone) {
        this.withStone = withStone;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cart> getClientCarts() {
        return clientCarts;
    }

    public void setClientCarts(List<Cart> clientCarts) {
        this.clientCarts = clientCarts;
    }
}
