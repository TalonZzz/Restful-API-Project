package com.example.restfulapiproject.service;

import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.domain.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    OrderDTO getOrderById(String id);
    List<OrderDTO> getAllOrders();
    CustomerDTO insertOrder(String name);
    void DeleteOrder(String id);
}
