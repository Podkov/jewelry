package com.store.jewelry.service;

import com.store.jewelry.model.Seller;
import com.store.jewelry.repository.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    @Transactional
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
    @Transactional
    public void deleteSeller(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    @Override
    @Transactional
    public void updateSeller(Long sellerId, String nickName, String password) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if (!sellerOptional.isPresent()){
            throw new EntityNotFoundException("Seller, id: " + sellerId);
        }
        Seller seller = sellerOptional.get();
        seller.setNickName(nickName);
        seller.setPassword(password);

        sellerRepository.save(seller);
    }
}
