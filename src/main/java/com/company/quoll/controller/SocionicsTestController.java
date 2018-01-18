package com.company.quoll.controller;

import com.company.quoll.model.RegistrationSocionicsSection;
import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.SocionicsTestForm;
import com.company.quoll.services.RegistrationSocionicsProvider;
import com.company.quoll.services.SocionicsResultService;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SocionicsTestController {

    @Autowired
    SocionicsResultService socionicsResultService;

    @Autowired
    UserService userService;

    @Autowired
    RegistrationSocionicsProvider socionicsProvider;

    @GetMapping("/user/test")
    public String test(Model model){
        final List<RegistrationSocionicsSection> sections = socionicsProvider.getSections();
        model.addAttribute("sections", sections);

        SocionicsTestForm form = new SocionicsTestForm();
        model.addAttribute("form", form);

        return "socionicsTest";
    }

    @PostMapping("/user/test")
    public String showProfile(SocionicsTestForm form, BindingResult bindingResult,
                              @AuthenticationPrincipal UserDetails currentUser) {

        final SocionicsResult result = form.makeResult();
        System.out.println(result.toString());

        // TODO: save result to database
        // TODO: spring validation?
        // TODO: redirect to profile to show the results (profile view not ready yet, therefore redirecting home for now)

        return "redirect:/";
    }


}
