package com.store.jewelry.service;

import com.store.jewelry.model.Admin;
import com.store.jewelry.model.Seller;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Long createAdmin(String nickName, String password);

    List<Admin> getAllAdmins();

    void deleteAdmin(Long adminId);

    void updateAdmin(Long adminId, String nickName, String password);

    Optional<Admin> getAdmin(Long adminId);

}
