package com.example.restservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Do not use @RestController annotation when you don't want @ResponseBody attached.
@Controller
public class LoginController {

    @GetMapping("/login")
    public String signin() {
        return "signin";
    }

}