package com.example.pp3_1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

   @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
