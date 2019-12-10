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


//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ModelAndView createNewSeller(String nickName, String password){
//        ModelAndView modelAndView = new ModelAndView();
//        Long id = sellerService.createSeller(nickName, password);
//
//        modelAndView.addObject("seller", new Seller());
//        modelAndView.setViewName("registra");
//
//        return modelAndView;
//    }



//    public String addSeller(){
//        sellerService.createSeller("nick1", "ababa");
//
//        List<Seller> sellers = sellerService.getAllSellers();
//
//        StringBuilder response = new StringBuilder();
//
//        for (Seller seller : sellers){
//            response.append(seller.getId());
//            response.append(seller.getNickName());
//            response.append('\n');
//        }
//        return response.toString();
//    }

}
