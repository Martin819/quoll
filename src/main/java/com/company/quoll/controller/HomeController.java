package com.company.quoll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    /*    @RequestMapping("/")
        public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
            model.addAttribute("username", username);
            return "index";
        }*/
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
