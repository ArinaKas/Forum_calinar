package com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Кулинарный фан-форум");
        model.addAttribute("message", "Добро пожаловать на форум!");
        return "index";
    }
}
