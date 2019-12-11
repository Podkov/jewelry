package com.store.jewelry.controller;

import com.store.jewelry.model.Cart;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.ClientOrder;
import com.store.jewelry.service.CartService;
import com.store.jewelry.service.ClientOrderService;
import com.store.jewelry.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/sellerPanel")
public class SellerController {

    @Autowired
    public ClientOrderService clientOrderService;

    @Autowired
    public ClientService clientService;

    @Autowired
    public CartService cartService;

    @RequestMapping("/")
    public String showMenu(){
        return "seller/menu";
    }

    @RequestMapping(value = "/addClientOrderForm")
    public String showClientOrderForm(Model model){

        ClientOrder clientOrder = new ClientOrder();
        model.addAttribute("clientOrder", clientOrder);
        //cartService.createCart(clientService.getClient(1L).get(), null, null, null, null, null);
        clientService.createClient("Henryk", "Mustafa", "Henio", "staff", null);

        return "seller/add-client-order";
    }

    @RequestMapping(value = "/showUpdateForm")
    public String showUpdateForm(@RequestParam("clientOrderId") Long clientOrderId, Model model){

        ClientOrder clientOrder = new ClientOrder();
        model.addAttribute("clientOrder", clientOrder);

        Optional<ClientOrder> clientOrderOptional = clientOrderService.getClientOrder(clientOrderId);
        if (clientOrderOptional.isPresent()){
            ClientOrder clientOrder1 = clientOrderOptional.get();
            model.addAttribute("clientOrder", clientOrder1);
        }
        return "seller/update-form";
    }

    @RequestMapping(value = "/save")
    public String saveClientOrder(@ModelAttribute("clientOrder") ClientOrder clientOrder){
        clientOrderService.createClientOrder(clientOrder.getDateOfOrder(), clientOrder.getOrderStatus(), clientOrder.getPrice(), clientOrder.getClientId());
        return "redirect:/sellerPanel/list";
    }

    @RequestMapping(value = "/update")
    public String updateClientOrder(@ModelAttribute("clientOrder") ClientOrder clientOrder){
        clientOrderService.updateClientOrder(clientOrder.getId(), clientOrder.getDateOfOrder(), clientOrder.getOrderStatus(), clientOrder.getPrice(), clientOrder.getClientId());
        return "redirect:/sellerPanel/list";
    }

    @RequestMapping(value = "/list")
    public String listClientOrders(Model model){
        List<ClientOrder> clientOrderList = clientOrderService.getAllClientOrders();
        model.addAttribute("clientOrders", clientOrderList);

        return "seller/list-client-orders";
    }

    @RequestMapping(value = "/delete")
    public String deleteClientOrder(@RequestParam("clientOrderId") Long clientOrderId){
        clientOrderService.deleteClientOrder(clientOrderId);
        return "redirect:/sellerPanel/list";
    }

//    @RequestMapping(value = "/changeStatus")
//    public String changeStatus(@ModelAttribute)
}
