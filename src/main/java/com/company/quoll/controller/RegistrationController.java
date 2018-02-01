package com.company.quoll.controller;

import com.company.quoll.model.Address;
import com.company.quoll.model.User;
import com.company.quoll.services.AddressService;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @Transactional
    @PostMapping("/registration")
    public String submitForm(@Valid User user, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!isUsernameUsable(user.getUsername())) {
            bindingResult.rejectValue("username", "error.username",
                    "Username already exists.");
            return "registration";
        }

        if (!isEmailUsable(user.getEmail())) {
            bindingResult.rejectValue("email", "error.email",
                    "Email already existst.");
            return "registration";
        }

        if (!user.getPassword().equals(user.getRepeatPassword())) {
            bindingResult.rejectValue("password", "error.user",
                    "Passwords do not match.");
            bindingResult.rejectValue("repeatPassword", "error.user",
                    "Passwords do not match.");
            return "registration";
        }

        final Address address = addressService.findAddressById(user.getAddressCode());
        if (address != null) {
            user.setAddress(address);
        } else {
            bindingResult.rejectValue("addressCode", "error.addressCode",
                    "Selected address not found in database.");
            return "registration";
        }

        userService.save(user);

        return "redirect:/login";
    }

    // REST

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

    //

    private boolean isUsernameUsable(String username) {
        return userService.findUserByUsername(username) == null;
    }

    private boolean isEmailUsable(String email) {
        return userService.findUserByEmail(email) == null;
    }

}
