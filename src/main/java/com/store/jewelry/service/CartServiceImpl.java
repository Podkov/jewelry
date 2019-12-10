package com.store.jewelry.service;

import com.store.jewelry.model.*;
import com.store.jewelry.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public Long createCart(Client client, ClientOrder clientOrder, List<Bracelet> braceletList, List<Earrings> earringsList, List<Necklace> necklaceList, List<Ring> ringList) {

        Cart cart = new Cart();
        cart.setClient(client);
        cart.setClientOrder(clientOrder);
        cart.setBracelets(braceletList);
        cart.setEarrings(earringsList);
        cart.setNecklaces(necklaceList);
        cart.setRings(ringList);

        cartRepository.save(cart);

        return cart.getId();
    }

    @Override
    public List<Cart> getAllCarts() {
        List<Cart> carts = new ArrayList<>();
        for (Cart cart: cartRepository.findAll()){
            carts.add(cart);
        }
        return carts;
    }

    @Override
    @Transactional
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    @Transactional
    public void updateCart(Long cartId, Client client, ClientOrder clientOrder, List<Bracelet> braceletList, List<Earrings> earringsList, List<Necklace> necklaceList, List<Ring> ringList) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (!cartOptional.isPresent()){
            throw new EntityNotFoundException("Cart, id: " + cartId);
        }

        Cart cart = cartOptional.get();
        cart.setClient(client);
        cart.setClientOrder(clientOrder);
        cart.setBracelets(braceletList);
        cart.setEarrings(earringsList);
        cart.setNecklaces(necklaceList);
        cart.setRings(ringList);

        cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> getCart(Long cartId) {
        return cartRepository.findById(cartId);
    }
}
