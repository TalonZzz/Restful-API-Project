package com.example.restfulapiproject.repository;

import com.example.restfulapiproject.domain.Customer;
import com.example.restfulapiproject.domain.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    CustomerDTO getCustomerById(String id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO insertCustomer(String name);
    CustomerDTO ChangeCustomerName(String id, String name);
    void DeleteCustomer(String id);

}
