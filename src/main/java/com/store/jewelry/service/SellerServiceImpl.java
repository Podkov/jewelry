package com.store.jewelry.service;

import com.store.jewelry.model.Seller;
import com.store.jewelry.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Long createSeller(String nickName, String password) {

        Seller seller = new Seller();
        seller.setNickName(nickName);
        seller.setPassword(password);

        sellerRepository.save(seller);

        return seller.getId();
    }

    @Override
    public List<Seller> getAllSellers() {
        List<Seller> sellers = new ArrayList<>();

        for (Seller s : sellerRepository.findAll()) {
            sellers.add(s);
        }

        return sellers;
    }

    @Override
    public void deleteSeller(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    @Override
    public void updateSeller(Long sellerId, String name, String password) {

    }
}
