package com.example.restservice.services;

import com.example.restservice.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleService {

    private static final Logger log = LoggerFactory.getLogger(ExampleService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean RegisterCustomers(List<Customer> customers) {

        List<Object[]> splitUpNames = customers
                .stream()
                .map(customer -> new String[] { customer.getFirstName(), customer.getLastName() })
                .collect(Collectors.toList());

        int[] size = jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        return size.length != 0;
    }

    public boolean RegisterCustomer(Customer customer) {

        Object[] names = new String[] { customer.getFirstName(), customer.getLastName() };
        int size = jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES (?,?)", names);

        return size != 0;
    }

    public String GetCustomer(String customerFirstName) {

        log.info("Querying for customer records where first_name = " + customerFirstName + ":");
        List<String> nameList = new ArrayList<String>();

        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { customerFirstName },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> {
            log.info(customer.toString());
            nameList.add(customer.toString() + ",");
        });
        return String.join(",", nameList);
    }
}
