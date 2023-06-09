package com.resttemplate.consumingapi.controller;

import com.resttemplate.consumingapi.model.Employee;
import com.resttemplate.consumingapi.service.ConsumingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumingController {


    private final ConsumingService consumingService;

    @Autowired
    public ConsumingController(ConsumingService consumingService) {
        this.consumingService = consumingService;
    }

    @GetMapping(path = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> allEmployee() {
        return new ResponseEntity<>(consumingService.fetchEmployeeData(), HttpStatus.OK);
    }

    @PostMapping(path = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEmployee(Employee employee) {
        consumingService.addEmployee(employee);
        return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
    }
}
