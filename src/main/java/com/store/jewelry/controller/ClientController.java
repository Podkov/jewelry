package com.store.jewelry.controller;

import com.store.jewelry.model.Client;
import com.store.jewelry.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    //inject the client dao
    @Autowired
    private ClientService clientService;


    @RequestMapping("/list")
    public String listCustomers(Model model){

        clientService.createClient("Maciej", "Podkowa", "Mac", "Pod", null);

        //get clients from dao
        List<Client> clients = clientService.getAllClients();

        //add the clients to the model
        model.addAttribute("clients", clients);

        return "list-customer";
    }

}
