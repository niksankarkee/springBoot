package com.practice.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/about")
    public String about(Model model) {

        System.out.println("Inside about handler....");

        model.addAttribute("name", "Nixon Karkee");
        model.addAttribute("currentDate", new Date().toLocaleString());

        // about.html
        return "about";
    }
}
