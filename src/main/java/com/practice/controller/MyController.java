package com.practice.controller;

import java.util.Date;
import java.util.List;

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

    // Handling iteration
    @GetMapping("/loop-example")
    public String iterateHandler(Model m) {

        // send

        // create a list, set collection
        List<String> names = List.of("Niksan", "Rijan", "Pratima");

        m.addAttribute("names", names);

        return "iterate";
    }

    // handling conditional statements

    @GetMapping("/condition")
    public String conditionHandler(Model model) {

        model.addAttribute("isActive", true);

        model.addAttribute("gender", "f");

        List<Integer> list = List.of();
        model.addAttribute("list", list);

        return "condition";
    }
}
