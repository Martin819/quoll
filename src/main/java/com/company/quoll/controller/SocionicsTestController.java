package com.company.quoll.controller;

import com.company.quoll.model.RegistrationSocionicsSection;
import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.SocionicsTestForm;
import com.company.quoll.model.User;
import com.company.quoll.services.RegistrationSocionicsProvider;
import com.company.quoll.services.SocionicsResultService;
import com.company.quoll.services.UserService;
import com.company.quoll.utils.SocionicsTypes;
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
    public String showProfile(SocionicsTestForm form, @AuthenticationPrincipal UserDetails activeUser) {
        final SocionicsResult result = form.makeResult();
        socionicsResultService.saveSocionicsResult(result);

        final User user = userService.findUserByUsername(activeUser.getUsername());
        user.setRepeatPassword(user.getPassword());
        user.setAddressCode(user.getAddress().getId());
        user.setSocionicsResult(result);
        user.setSocionicsType(SocionicsTypes.getTypeCode(result));
        userService.update(user);

        return "redirect:/user/profile";
    }


}
