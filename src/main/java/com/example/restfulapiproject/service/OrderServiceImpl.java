package com.example.restfulapiproject.service;

import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.domain.OrderDTO;
import com.example.restfulapiproject.repository.CustomerRepository;
import com.example.restfulapiproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public OrderDTO getOrderById(String id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public CustomerDTO insertOrder(String name) {
        return null;
    }

    @Override
    public void DeleteOrder(String id) {

    }
}
