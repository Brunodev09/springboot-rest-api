package com.example.restservice.controllers;

import com.example.restservice.domain.Customer;
import com.example.restservice.responses.CustomerPostResponse;
import com.example.restservice.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    ExampleService exampleService;

    @PostMapping("/customers")
    public CustomerPostResponse customerController(@RequestBody List<Customer> customer) {
        if (!exampleService.RegisterCustomers(customer)) return new CustomerPostResponse(400, "Invalid id!");
        return new CustomerPostResponse(200, "Customers successfully registered!");
    }

    @PostMapping("/customer")
    public CustomerPostResponse singleCustomer(@RequestBody Customer customer) {
        if (!exampleService.RegisterCustomer(customer)) return new CustomerPostResponse(400, "Invalid id!");
        return new CustomerPostResponse(200, "Customer successfully registered!");
    }

    @GetMapping("/customer")
    public CustomerPostResponse getCustomer(@RequestParam String name) {
        String query = exampleService.GetCustomer(name);
        if (query.length() == 0) return new CustomerPostResponse(400, "No results.");
        return new CustomerPostResponse(200, query);
    }
}
