package com.example.restfulapiproject.controller;

import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.domain.OrderDTO;
import com.example.restfulapiproject.service.CustomerService;
import com.example.restfulapiproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/read")
    public ResponseEntity<OrderDTO> getCustomerById(@RequestParam String id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }


}
