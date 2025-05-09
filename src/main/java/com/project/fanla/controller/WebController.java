package com.project.fanla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "redirect:/fan.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "redirect:/admin.html";
    }
}
