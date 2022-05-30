package com.example.restfulapiproject.service;

import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public CustomerDTO insertCustomer(String name) {
        return customerRepository.insertCustomer(name);
    }

    @Override
    public CustomerDTO ChangeCustomerName(String id, String name) {
        return customerRepository.ChangeCustomerName(id,name);
    }

    @Override
    public void DeleteCustomer(String id) {
        customerRepository.DeleteCustomer(id);
    }


}
