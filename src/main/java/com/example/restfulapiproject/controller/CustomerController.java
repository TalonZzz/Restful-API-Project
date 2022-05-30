package com.example.restfulapiproject.controller;

import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/customers/create")
    public ResponseEntity<CustomerDTO> insertCustomer(@RequestParam String name) {
        return new ResponseEntity<>(customerService.insertCustomer(name), HttpStatus.OK);
    }

    @GetMapping("/customers/read")
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam String id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("/customers/update")
    public ResponseEntity<CustomerDTO> ChangeName(@RequestParam String id, @RequestParam String name) {
        return new ResponseEntity<>(customerService.ChangeCustomerName(id,name), HttpStatus.OK);
    }

    @PostMapping("/customers/delete")
    public ResponseEntity<CustomerDTO> deleteCustomer(@RequestParam String id) {
       customerService.DeleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customers/readall")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }



}
