package com.company.quoll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/user/profile")
    public String showProfile() {
        return "profile";
    }

}
