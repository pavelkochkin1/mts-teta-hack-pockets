package com.example.JsonOrHtmlApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/**")
    public String pageNotFound() {
        return "not_found";
    }

    @GetMapping("")
    public String getPage(Model model) {
        model.addAttribute("activePage", "home");
        return "home_page";
    }
}
