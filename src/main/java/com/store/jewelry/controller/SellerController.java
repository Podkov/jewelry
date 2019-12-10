package com.store.jewelry.controller;

import com.store.jewelry.model.Seller;
import com.store.jewelry.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SellerController {

    @Autowired
    public SellerService sellerService;

    @RequestMapping(value = "/registration")
    public String registration(Model model){

        Seller seller = new Seller();
        model.addAttribute("seller", seller);

        return "registration";
    }
    
}
