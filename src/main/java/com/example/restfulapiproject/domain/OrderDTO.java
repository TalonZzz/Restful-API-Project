package com.example.restfulapiproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String id;
    private Customer customer;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.customer = order.getCustomer();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                "customer_id='" + customer.getId() + '\'' +
                '}';
    }
}
