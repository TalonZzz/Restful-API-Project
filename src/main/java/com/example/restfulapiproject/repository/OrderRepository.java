package com.example.restfulapiproject.repository;

import com.example.restfulapiproject.domain.Customer;
import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.domain.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository {
    OrderDTO getOrderById(String id);
    List<OrderDTO> getAllOrders();
    OrderDTO insertOrder(Customer order);
    void DeleteOrder(String id);
}
