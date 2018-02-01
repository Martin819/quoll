package com.company.quoll.controller;

import com.company.quoll.model.User;
import com.company.quoll.services.UserService;
import com.company.quoll.utils.ZodiacSigns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    UserService userService;

    @GetMapping("/user/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal UserDetails activeUser,
                                @RequestParam(required = false) String onlyMyCountry,
                                @RequestParam(required = false) String men,
                                @RequestParam(required = false) String women,
                                @RequestParam(required = false) Integer ageMin,
                                @RequestParam(required = false) Integer ageMax,
                                @RequestParam(required = false) Integer sliderValue) {
        final User user = userService.findUserByUsername(activeUser.getUsername());
        List<User> matchedUsers = new ArrayList<>();
        if (sliderValue == null) {
            sliderValue = 2;
        }
        for (int i = 1; i <= sliderValue; i++) {
            final List<User> resultUsers = userService.getMatchedUsersByFitnessOrder(user, i, onlyMyCountry, men, women, ageMin, ageMax);
            matchedUsers.addAll(resultUsers);
        }
        model.addAttribute("user", user);
        model.addAttribute("matchedUsers", matchedUsers);
        model.addAttribute("zodiacSigns", ZodiacSigns.getZodiacSigns());
        return "dashboard";
    }

}
