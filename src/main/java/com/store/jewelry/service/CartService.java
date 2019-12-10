package com.store.jewelry.service;

import com.store.jewelry.model.*;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Long createCart(Client client, ClientOrder clientOrder, List<Bracelet> braceletList, List<Earrings> earringsList, List<Necklace> necklaceList, List<Ring> ringList);

    List<Cart> getAllCarts();

    void deleteCart(Long cartId);

    void updateCart(Long cartId, Client client, ClientOrder clientOrder, List<Bracelet> braceletList, List<Earrings> earringsList, List<Necklace> necklaceList, List<Ring> ringList);

    Optional<Cart> getCart(Long cartId);

}
