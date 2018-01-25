package com.company.quoll.controller;

import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.User;
import com.company.quoll.services.SocionicsResultService;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    SocionicsResultService socionicsResultService;

    @Autowired
    UserService userService;


    @GetMapping("/user/profile")
    public String showProfile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.findUserByUsername(currentUser.getUsername());
        userService.addSocionicsTypeToUser(user);
        SocionicsResult userResults = user.getSocionicsResult();
        String userSocionicsType = user.getSocionicsType();
        model.addAttribute("userResults", userResults);
        model.addAttribute("userSocionicsType", userSocionicsType);
        System.out.println(userSocionicsType);
        return "dashboard";
    }

}
