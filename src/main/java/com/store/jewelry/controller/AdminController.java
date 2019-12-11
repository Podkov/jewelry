package com.store.jewelry.controller;

import com.store.jewelry.model.Address;
import com.store.jewelry.model.Client;
import com.store.jewelry.model.Seller;
import com.store.jewelry.service.AddressService;
import com.store.jewelry.service.ClientService;
import com.store.jewelry.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {


    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/menu")
    String showMenu(Model model) {
        return "admin/menu";
    }

    @RequestMapping(value = "/seller/list")
    public String listSellers(Model model) {

        List<Seller> sellerList = sellerService.getAllSellers();
        model.addAttribute("sellers", sellerList);

        return "admin/list-sellers";
    }

    @RequestMapping(value = "/seller/addForm")
    public String showSellerForm(Model model) {
        Seller seller = new Seller();
        model.addAttribute("seller", seller);
        return "admin/add-seller-form";
    }

    @RequestMapping(value = "/seller/save")
    public String saveSeller(@ModelAttribute("seller") Seller seller) {
        sellerService.createSeller(seller.getNickName(), seller.getPassword());
        return "redirect:/admin/seller/list";
    }

    @RequestMapping(value = "/seller/showUpdateForm", method = RequestMethod.GET)
    public String showUpdateForm(@RequestParam("sellerId") Long sellerId, Model model) {

        Seller seller = new Seller();
        model.addAttribute("seller", seller);

        Optional<Seller> seller2 = sellerService.getSeller(sellerId);
        if (seller2.isPresent()) {
            Seller seller1 = seller2.get();
            model.addAttribute("seller", seller1);
        }
        return "admin/update-seller-form";
    }

    @RequestMapping(value = "/seller/update")
    public String updateSeller(@ModelAttribute("seller") Seller seller) {

        sellerService.updateSeller(seller.getId(), seller.getNickName(), seller.getPassword());

        return "redirect:/admin/seller/list";
    }

    @RequestMapping(value = "/seller/delete")
    public String delete(@RequestParam("sellerId") Long sellerId) {
        sellerService.deleteSeller(sellerId);
        return "redirect:/admin/seller/list";
    }

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client/list")
    public String listClients(Model model) {

        List<Client> clientList = clientService.getAllClients();
        model.addAttribute("clients", clientList);

        return "admin/list-clients";
    }

    @RequestMapping(value = "/client/addForm")
    public String showClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "admin/add-client-form";
    }

    @RequestMapping(value = "/client/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.createClient(client.getFirstName(), client.getLastName(), client.getNickName(), client.getPassword(), null);
        return "redirect:/admin/client/list";
    }

    @RequestMapping(value = "/client/showUpdateForm")
    public String showClientUpdateForm(@RequestParam("clientId") Long clientId, Model model) {

        Client client = new Client();
        model.addAttribute("client", client);

        Optional<Client> client2 = clientService.getClient(clientId);
        if (client2.isPresent()) {
            Client client1 = client2.get();
            model.addAttribute("client", client1);
        }
        return "admin/update-client-form";
    }

    @RequestMapping(value = "/client/update")
    public String updateClient(@ModelAttribute("client") Client client) {

        clientService.updateClient(client.getId(), client.getFirstName(), client.getLastName(), client.getNickName(), client.getPassword());

        return "redirect:/admin/client/list";
    }

    @RequestMapping(value = "/client/delete")
    public String deleteClient(@RequestParam("clientId") Long clientId) {

        clientService.deleteClient(clientId);

        return "redirect:/admin/client/list";
    }

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/client/address/list")
    public String showAddressList(@RequestParam("clientId") long clientId, Model model) {
        Client client = null;

        Optional<Client> clientOptional = clientService.getClient(clientId);
        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }

        List<Address> addresses = addressService.getAllAddresses(clientId);

        model.addAttribute("addresses", addresses);
        model.addAttribute("client", client);

        return "admin/list-addresses";

    }

    @RequestMapping(value = "/client/address/addForm")
    public String showAddressForm(@RequestParam("clientId") Long clientId, @ModelAttribute("client") Client client, Model model) {

        Address address = new Address();
        model.addAttribute("address", address);
        model.addAttribute("clientId", clientId);

        return "admin/add-address-form";

    }

    @RequestMapping(value = "/client/address/save")
    public String saveAddress(@RequestParam("clientId") Long clientId, @ModelAttribute("address") Address address) {

        List<Address> addressList = clientService.getClient(clientId).get().getAddresses();
        addressList.add(address);

        clientService.getClient(clientId).get().setAddresses(addressList);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("redirect:/admin/client/address/list?clientId=");
        stringBuilder.append(clientId);

        return stringBuilder.toString();

    }

    @RequestMapping(value = "/client/address/delete")
    public String deleteAddress(@RequestParam("addressId") Long addressId) {

        addressService.deleteAddress(addressId);

        return "redirect:/admin/client/list";

    }

    @RequestMapping(value = "/client/address/showUpdateForm")
    public String showAddressUpdateForm(@ModelAttribute("addressId") Long addressId, Model model) {

        Address address1 = new Address();
        model.addAttribute("address", address1);

        Optional<Address> address2 = addressService.getAddress(addressId);
        if (address2.isPresent()) {
            Address address3 = address2.get();
            model.addAttribute("address", address3);
        }

        return "admin/update-address-form";

    }

    @RequestMapping(value = "/client/address/update")
    public String updateSeller(@ModelAttribute("address") Address address) {
        addressService.updateAddress(address.getId(), address.getZipCode(), address.getStreet(), address.getHouseNumber(), address.getApartmentNumber(), address.getClients());
        return "redirect:/admin/client/list";

    }


}
