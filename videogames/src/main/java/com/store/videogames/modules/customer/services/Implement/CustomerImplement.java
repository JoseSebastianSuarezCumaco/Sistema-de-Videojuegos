package com.store.videogames.modules.customer.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.customer.entity.Customer;
import com.store.videogames.modules.customer.repository.CustomerRepository;
import com.store.videogames.modules.customer.services.Interface.ICustomer;

@Service
public class CustomerImplement implements ICustomer {

    @Autowired
    CustomerRepository data;

    @Override
    public String Create(Customer customer) {
        try {
            data.save(customer);
            return "Customer created successfully";
        } catch (Exception e) {
            return "Error creating customer: " + e.getMessage();
        }
    }

    @Override
    public List<Customer> GetAll() {
        return data.findAll();
    }

    @Override
    public Customer GetById(String customerId) {
        Optional<Customer> customer = data.findById(customerId);
        if (!customer.isPresent()) {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }
        return customer.get();
    }

    @Override
    public Customer Update(String customerId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Customer PartialUpdate(String customerId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(String customerId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(String customerId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}