package com.imie.poec.java.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingFrontController {

    @GetMapping("/front/greeting")
    public String greet() {
        return "greet";
    }
}
