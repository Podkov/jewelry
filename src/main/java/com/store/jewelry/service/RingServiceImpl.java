package com.store.jewelry.service;

import com.store.jewelry.model.Cart;
import com.store.jewelry.model.Ring;
import com.store.jewelry.repository.RingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RingServiceImpl implements RingService {

    private RingRepository ringRepository;

    public RingServiceImpl(RingRepository ringRepository) {
        this.ringRepository = ringRepository;
    }

    @Override
    @Transactional
    public Long createRing(float price, String name, boolean withStone, double size, String materialType, boolean isRealDiamond, List<Cart> clientCarts) {

        Ring ring = new Ring();
        ring.setPrice(price);
        ring.setName(name);
        ring.setWithStone(withStone);
        ring.setSize(size);
        ring.setMaterialType(materialType);
        ring.setRealDiamond(isRealDiamond);
        ring.setClientCarts(clientCarts);

        ringRepository.save(ring);

        return ring.getId();
    }

    @Override
    public List<Ring> getAllRing() {
        List<Ring> rings = new ArrayList<>();
        for (Ring ring: ringRepository.findAll()){
            rings.add(ring);
        }

        return rings;
    }

    @Override
    @Transactional
    public void deleteRing(Long ringId) {
        ringRepository.deleteById(ringId);
    }

    @Override
    @Transactional
    public void updateRing(Long ringId, float price, String name, boolean withStone, double size, String materialType, boolean isRealDiamond, List<Cart> clientCarts) {
        Optional<Ring> ringOptional = ringRepository.findById(ringId);
        if (!ringOptional.isPresent()){
            throw new EntityNotFoundException("Ring, id: " + ringId);
        }

        Ring ring = ringOptional.get();
        ring.setPrice(price);
        ring.setName(name);
        ring.setWithStone(withStone);
        ring.setSize(size);
        ring.setMaterialType(materialType);
        ring.setRealDiamond(isRealDiamond);
        ring.setClientCarts(clientCarts);

        ringRepository.save(ring);
    }

    @Override
    public Optional<Ring> getRing(Long ringId) {
        return ringRepository.findById(ringId);
    }
}
