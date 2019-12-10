package com.store.jewelry.service;

import com.store.jewelry.model.Seller;

import java.util.List;

public interface SellerService {

    Long createSeller(String nickName, String password);

    List<Seller> getAllSellers();

    void deleteSeller(Long sellerId);

    void updateSeller(Long sellerId, String name, String password);

}
