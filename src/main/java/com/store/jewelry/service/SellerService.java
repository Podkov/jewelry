package com.store.jewelry.service;

import com.store.jewelry.model.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService {

    Long createSeller(String nickName, String password);

    List<Seller> getAllSellers();

    void deleteSeller(Long sellerId);

    void updateSeller(Long sellerId, String nickName, String password);

    Optional<Seller> getSeller (Long sellerId);

}
