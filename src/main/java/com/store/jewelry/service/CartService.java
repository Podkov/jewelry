package com.store.jewelry.service;

import com.store.jewelry.model.*;

import java.util.List;

public interface CartService {

    Long createCart(Client client, ClientOrder clientOrder, List<Bracelet> braceletList, List<Earrings> earringsList, List<Necklace> necklaceList, List<Ring> ringList);

    List<Cart> getAllCarts();

    void deleteCart(Long cartId);

    void updateCart(Long cartId, Client client, ClientOrder clientOrder, List<Bracelet> braceletList, List<Earrings> earringsList, List<Necklace> necklaceList, List<Ring> ringList);

}
