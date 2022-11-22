package com.example.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/calc2")
    public String getCalc() {
        return "home";
    }

    @PostMapping("/calc")
    public String postResult(
            @RequestParam(
                    value = "variable",
                    required = false,
                    defaultValue = "0") double a,
            @RequestParam(
                    value = "variable2",
                    required = false,
                    defaultValue = "0") double b,
            @RequestParam char operation,
            Model model) {

        double c = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalStateException("Error =|: " + operation);
        };

        model.addAttribute("first", a);
        model.addAttribute("second", b);
        model.addAttribute("operation", operation);
        model.addAttribute("answer", c);
        return "home";
    }

    @GetMapping("/calc")
    public String getResult(
            @RequestParam(
                    value = "variable",
                    required = false,
                    defaultValue = "0") double a,
            @RequestParam(
                    value = "variable2",
                    required = false,
                    defaultValue = "0") double b,
            @RequestParam char operation,
            Model model) {

        double c = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalStateException("Error =|: " + operation);
        };

        model.addAttribute("first", a);
        model.addAttribute("second", b);
        model.addAttribute("operation", operation);
        model.addAttribute("answer", c);
        return "home";
    }

}
