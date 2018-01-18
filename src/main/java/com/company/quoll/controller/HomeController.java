package com.company.quoll.controller;

import com.company.quoll.model.SocionicsResult;
import com.company.quoll.model.User;
import com.company.quoll.repository.UserRepository;
import com.company.quoll.services.SocionicsResultService;
import com.company.quoll.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;


@Controller
public class HomeController {

    @Autowired
    SocionicsResultService socionicsResultService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home1(Model model) {
        model.addAttribute("page_title", "quoll");
        return "/index";
    }

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("page_title", "quoll");
        return "index";
    }

    @GetMapping("/mock")
    public String mock() {
        List<User> users = userRepository.findAll();
        for (User user:users) {
            user.setSocionicsType(SocionicsTypes.getTypeCode(user.getSocionicsResult()));
            user.setZodiacSign(ZodiacSigns.getZodiacSign(user.getDateOfBirth()));
            System.out.println(user.getSocionicsResult().getId().toString());
            System.out.println(SocionicsTypes.getTypeCode(user.getSocionicsResult()));
            System.out.println(user.getSocionicsType());
            userRepository.save(user);
        }
        SocionicsResult result2 = new SocionicsResult(UUID.randomUUID(),0.2f, 0.3f, 0.5f, 0.2f);
        socionicsResultService.saveSocionicsResult(result2);
        return "mock";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("error/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/password-reset")
    public String passwordreset() {
        return "/password-reset";
    }

}
