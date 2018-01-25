package com.company.quoll.controller;

import com.company.quoll.model.Address;
import com.company.quoll.model.User;
import com.company.quoll.services.AddressService;
import com.company.quoll.services.UserService;
import com.company.quoll.utils.ZodiacSigns;
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

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String getForm(Model model) {
        final List<Address> countries = addressService.findAddresses(null, 0);
        model.addAttribute("countries", countries);
        User user = new User();
        model.addAttribute("user", user);
//        RegistrationForm registrationForm = new RegistrationForm();
//        model.addAttribute("registrationForm", registrationForm);
        // TODO address
        return "registration";
    }

/*    @PostMapping("/registration")
    public String submitForm(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        System.out.println("SUBMIT");
        System.out.println(registrationForm.getUsername());
        System.out.println(registrationForm.getDateOfBirth());
        System.out.println(registrationForm.getNuts0());
        System.out.println(registrationForm.getEmail());
        System.out.println(registrationForm.getPassword());
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return "registration";
        }
        return "redirect:/";
    }*/

    @PostMapping("/registration")
    public String submitForm(@Valid User user, BindingResult bindingResult) {
        System.out.println(user.getUsername());
        System.out.println(user.getDateOfBirth());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getAddressCode());
        System.out.println(user.getRepeatPassword());

        if (bindingResult.hasErrors()) {
            System.out.println("hasErrors");
            System.out.println(bindingResult.getAllErrors().toString());
            return "registration";
        }

        if (!user.getPassword().equals(user.getRepeatPassword())) {
            bindingResult.rejectValue("password", "error.user", "Passwords do not match.");
            bindingResult.rejectValue("repeatPassword", "error.user", "Passwords do not match.");
            return "registration";
        }

        final Address address = addressService.findAddressById(user.getAddressCode());
        if (address != null) {
            user.setAddress(address);
        } else {
            System.err.println("No address with provided id found in the database.");
        }

        user.setZodiacSign(ZodiacSigns.getZodiacSign(user.getDateOfBirth()));

        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/registration/nuts0")
    public @ResponseBody List<Address> getNuts0() {
        return addressService.findAddresses(null, 0);
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
