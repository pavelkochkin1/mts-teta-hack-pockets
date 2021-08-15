package com.example.JsonOrHtmlApplication.controller;

import com.example.JsonOrHtmlApplication.domain.UrlEntity;
import com.example.JsonOrHtmlApplication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.script.*;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/ml-model")
public class MainController {
    private final MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getHomePage(Model model) throws ScriptException, IOException, InterruptedException {
        UrlEntity currentEntity = service.findCurrentEntity();

        model.addAttribute("entity", new UrlEntity());
        model.addAttribute("currentEntity", currentEntity);
        model.addAttribute("urls", service.findAll());
        model.addAttribute("activePage", "ml-model");

        if (currentEntity != null) {
            currentEntity.setDataType(service.getDataType(currentEntity.getLink()));
            currentEntity.setProbability(Math.ceil(service.getProbability(currentEntity.getLink())));
        }

        return "ml_page";
    }

    @PostMapping("")
    public String submitUrlEntity(@Valid UrlEntity entity) {
        service.save(entity);
        return "redirect:/ml-model";
    }
}
