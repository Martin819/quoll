package com.company.quoll.controller;

import com.company.quoll.model.Address;
import com.company.quoll.model.RegistrationForm;
import com.company.quoll.model.User;
import com.company.quoll.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    AddressService addressService;

    @GetMapping("/registration")
    public String getForm(Model model) {
        final List<Address> countries = addressService.findAddresses(null, 0);
        model.addAttribute("countries", countries);
//        User user = new User();
//        model.addAttribute("user", user);
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("registrationForm", registrationForm);
        // TODO address
        return "registration";
    }

    @PostMapping("/registration")
    public String submitForm(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        System.out.println("SUBMIT");
        System.out.println(registrationForm.getUsername());
        System.out.println(registrationForm.getDateOfBirth());
        System.out.println(registrationForm.getEmail());
        System.out.println(registrationForm.getPassword());
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return "registration";
        }
        return "redirect:/";
    }

//    @PostMapping("/registration")
//    public String submitForm(@Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println("hasErrors");
//            System.out.println(user.getUsername());
//            System.out.println(user.getDateOfBirth());
//            System.out.println(user.getEmail());
//            System.out.println(user.getPassword());
//            System.out.println(bindingResult.getAllErrors().toString());
//            return "registration";
//        }
//        System.out.println("does not have errors");
//        System.out.println(user.getUsername());
//        System.out.println(user.getDateOfBirth());
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        return "redirect:/";
//    }

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
