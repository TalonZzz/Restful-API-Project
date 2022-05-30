package com.example.restfulapiproject.repository;

import com.example.restfulapiproject.domain.Customer;
import com.example.restfulapiproject.domain.CustomerDTO;
import com.example.restfulapiproject.exception.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private EntityManager em;

    @Autowired
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = em.find(Customer.class,id);
        if(customer==null) throw new InvalidIdException("This id is invalid.");
        return new CustomerDTO(customer);
        /*
        try{
            Query query = em.createQuery("FROM Customer WHERE id = :id");
            query.setParameter("id",id);
            Customer i = (Customer)query.getSingleResult();
            return new CustomerDTO(i);
        }catch (NoResultException e){
            throw new InvalidIdException("This id is invalid.");
        }*/
    }


    @Override
    public List<CustomerDTO> getAllCustomers() {
        Query query = em.createQuery("FROM Customer");
        List<Customer> list = query.getResultList();
        return list.stream().map(customer -> new CustomerDTO(customer)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerDTO insertCustomer(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        em.persist(customer);
        return new CustomerDTO(customer);
    }

    @Override
    @Transactional
    public CustomerDTO ChangeCustomerName(String id, String name) {
        Customer customer = em.find(Customer.class,id);
        if(customer==null) throw new InvalidIdException("This id is invalid.");
        customer.setName(name);
        return new CustomerDTO(customer);
    }

    @Override
    @Transactional
    public void DeleteCustomer(String id) {
        Query query = em.createQuery("DELETE FROM Customer WHERE id = :id");
        query.setParameter("id",id);
        query.executeUpdate();

        /*Why it doesn't work???
        Customer customer = em.find(Customer.class,id);
        if(customer==null) throw new InvalidIdException("This id is invalid.");
        em.remove(customer);*/
    }
}
