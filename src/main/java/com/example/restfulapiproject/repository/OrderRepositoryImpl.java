package com.example.restfulapiproject.repository;

import com.example.restfulapiproject.domain.Customer;
import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.domain.Order;
import com.example.restfulapiproject.domain.OrderDTO;
import com.example.restfulapiproject.exception.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private EntityManager em;

    @Autowired
    public OrderRepositoryImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public OrderDTO getOrderById(String id) {
        Order order = em.find(Order.class,id);
        if(order==null) throw new InvalidIdException("This id is invalid.");
        return new OrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO insertOrder(Customer customer) {
        Order order = new Order();
        order.setCustomer(customer);
        em.persist(order);
        return new OrderDTO(order);
    }

    @Override
    public void DeleteOrder(String id) {

    }
}
