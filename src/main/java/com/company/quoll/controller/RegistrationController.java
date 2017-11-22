package com.company.quoll.controller;

import com.company.quoll.model.Address;
import com.company.quoll.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    AddressService addressService;

    @RequestMapping("/registration")
    public String getForm(Model model) {
        final List<Address> countries = addressService.findAddresses(null, 0);
        model.addAttribute("countries", countries);
        return "registration";
    }

    @GetMapping("/registration/nuts1")
    public @ResponseBody List<Address> getNuts1(@RequestParam String nuts0) {
        return addressService.findAddresses(nuts0, 1);
    }

    @GetMapping("/registration/nuts2")
    public @ResponseBody List<Address> getNuts2(@RequestParam String nuts1) {
        return addressService.findAddresses(nuts1, 2);
    }

    @GetMapping("/registration/nuts3")
    public @ResponseBody List<Address> getNuts3(@RequestParam String nuts2) {
        return addressService.findAddresses(nuts2, 3);
    }

}
