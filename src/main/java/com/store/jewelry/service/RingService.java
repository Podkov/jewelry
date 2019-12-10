package com.store.jewelry.service;

import com.store.jewelry.model.Admin;
import com.store.jewelry.model.Cart;
import com.store.jewelry.model.Ring;

import java.util.List;

public interface RingService {

    Long createRing(float price, String name, boolean withStone, double size, String materialType, boolean isRealDiamond, List<Cart> clientCarts);

    List<Ring> getAllRing();

    void deleteRing(Long ringId);

    void updateRing(Long ringId, float price, String name, boolean withStone, double size, String materialType, boolean isRealDiamond, List<Cart> clientCarts);

}
