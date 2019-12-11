package com.store.jewelry.controller;

import ch.qos.logback.core.boolex.EvaluationException;
import com.store.jewelry.model.Seller;
import com.store.jewelry.service.SellerService;
import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

        Optional<Seller> seller = sellerService.getSeller(sellerId);
        if (seller.isPresent()) {
            Seller seller1 = seller.get();
            model.addAttribute("seller", seller1);
        }
        return "add-seller-form";
    }

    @RequestMapping(value = "/save")
    public String saveSeller(@ModelAttribute("seller") Seller seller) {
        sellerService.createSeller(seller.getNickName(), seller.getPassword());
        return "redirect:/seller/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listSellers(Model model) {

        List<Seller> sellerList = sellerService.getAllSellers();
        model.addAttribute("sellers", sellerList);

        return "list-sellers";
    }

}
