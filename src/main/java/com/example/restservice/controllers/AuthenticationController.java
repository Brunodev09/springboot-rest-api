package com.example.restservice.controllers;

import com.example.restservice.forms.LoginForm;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Do not use @RestController annotation when you don't want @ResponseBody attached.
@Controller
public class AuthenticationController {

    @PostMapping(path = "/auth", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String auth(LoginForm form) {
        return "signin";
    }

}