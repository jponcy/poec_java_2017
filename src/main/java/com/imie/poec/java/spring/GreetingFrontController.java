package com.imie.poec.java.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingFrontController {

    @GetMapping("/front/greeting")
    public String greet(Model model, @RequestParam String name) {
        model.addAttribute("name", name);

        return "greet";
    }
}
