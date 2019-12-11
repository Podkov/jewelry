package com.store.jewelry.controller;

import com.store.jewelry.model.Seller;
import com.store.jewelry.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/seller")
public class SellerController {

    @Autowired
    public SellerService sellerService;

    @RequestMapping(value = "/addSellerForm", method = RequestMethod.GET)
    public String registration(Model model) {

        Seller seller = new Seller();
        model.addAttribute("seller", seller);

        return "add-seller-form";
    }

    @RequestMapping(value = "/showUpdateForm", method = RequestMethod.GET)
    public String showUpdateForm(@RequestParam("sellerId") Long sellerId, Model model) {

        Seller seller = new Seller();
        model.addAttribute("seller", seller);

        Optional<Seller> seller2 = sellerService.getSeller(sellerId);
        if (seller2.isPresent()) {
            Seller seller1 = seller2.get();
            model.addAttribute("seller", seller1);
        }
        return "update-seller-form";
    }

    @RequestMapping(value = "/save")
    public String saveSeller(@ModelAttribute("seller") Seller seller) {
        sellerService.createSeller(seller.getNickName(), seller.getPassword());
        return "redirect:/seller/list";
    }

    @RequestMapping(value = "/update")
    public String updateSeller(@ModelAttribute("seller") Seller seller){
        sellerService.updateSeller(seller.getId(), seller.getNickName(), seller.getPassword());
        return "redirect:/seller/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listSellers(Model model) {

        List<Seller> sellerList = sellerService.getAllSellers();
        model.addAttribute("sellers", sellerList);

        return "list-sellers";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("sellerId") Long sellerId){
        sellerService.deleteSeller(sellerId);
        return "redirect:/seller/list";
    }


}
