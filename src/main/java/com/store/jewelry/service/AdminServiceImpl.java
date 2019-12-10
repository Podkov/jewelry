package com.store.jewelry.service;

import com.store.jewelry.model.Admin;
import com.store.jewelry.model.Seller;
import com.store.jewelry.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public Long createAdmin(String nickName, String password) {

        Admin admin = new Admin();
        admin.setNickName(nickName);
        admin.setPassword(password);

        adminRepository.save(admin);

        return admin.getId();
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();

        for (Admin admin: adminRepository.findAll()){
            admins.add(admin);
        }

        return admins;
    }

    @Override
    @Transactional
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    @Override
    @Transactional
    public void updateAdmin(Long adminId, String nickName, String password) {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (!adminOptional.isPresent()){
            throw new EntityNotFoundException("Admin, id: " + adminId);
        }
        Admin admin = adminOptional.get();
        admin.setNickName(nickName);
        admin.setPassword(password);

        adminRepository.save(admin);
    }
}
