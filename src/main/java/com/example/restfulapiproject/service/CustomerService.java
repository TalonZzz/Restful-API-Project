package com.example.restfulapiproject.service;

import com.example.restfulapiproject.domain.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDTO getCustomerById(String id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO insertCustomer(String name);
    CustomerDTO ChangeCustomerName(String id, String name);
    void DeleteCustomer(String id);
}
