package com.company.quoll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

/*    @RequestMapping("/")
    public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        return "index";
    }*/
    @GetMapping("/")
    public String home1() {
        return "/index";
    }

    @GetMapping("/index")
    public String home() {
        return "/index";
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

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("error/403")
    public String error403() {
        return "/error/403";
    }
}