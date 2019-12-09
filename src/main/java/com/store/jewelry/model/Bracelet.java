package com.store.jewelry.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bracelet{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private float price;

    @Column
    private String name;

    @Column
    private String materialType;

    @Column
    private boolean isRealDiamond;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "client_order_bracelet",
            joinColumns = @JoinColumn(name = "bracelet_id"),
            inverseJoinColumns = @JoinColumn(name = "client_order_id")
    )
    private List<ClientOrder> clientOrders;

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
}
