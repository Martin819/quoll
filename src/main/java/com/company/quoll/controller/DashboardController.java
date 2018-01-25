package com.company.quoll.controller;

import com.company.quoll.model.User;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    UserService userService;

    @GetMapping("/user/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal UserDetails activeUser) {
        final User user = userService.findUserByUsername(activeUser.getUsername());
        model.addAttribute("user", user);
        return "dashboard";
    }

}
