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

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    UserService userService;

    @GetMapping("/user/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal UserDetails activeUser) {
        final User user = userService.findUserByUsername(activeUser.getUsername());
        final List<User> matchedUsers = userService.getMatchedUsersByFitnessOrder(user, 1);
        model.addAttribute("user", user);
        model.addAttribute("matchedUsers", matchedUsers);
        model.addAttribute("zodiacSigns", ZodiacSigns.getZodiacSigns());
        return "dashboard";
    }

}
