package com.company.quoll.controller;

import com.company.quoll.model.Address;
import com.company.quoll.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public @ResponseBody List<Address> getNuts1() {
        return addressService.findAddresses("CZ", 1);
    }

}
