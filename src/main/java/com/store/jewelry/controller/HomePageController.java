package com.store.jewelry.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String showHomePage(){
        return "core-pages/home-page";
    }

    @RequestMapping("/zaloguj")
    public String showLoginPage(){
        return "core-pages/login-page";
    }

}
