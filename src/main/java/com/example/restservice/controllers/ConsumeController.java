package com.example.restservice.controllers;

import com.example.restservice.services.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {

    @Autowired
    ConsumeService Service;

    @GetMapping("/request")
    public String index() {
        return Service.makeRandomRequest();
    }

}
