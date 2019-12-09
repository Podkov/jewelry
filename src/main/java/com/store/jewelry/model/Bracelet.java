package com.store.jewelry.model;

import javax.persistence.*;

@Entity
public class Bracelet extends Product{

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
