package com.store.videogames.modules.customer.services.Interface;

import java.util.List;
import com.store.videogames.modules.customer.entity.Customer;

public interface ICustomer {
    public String Create(Customer customer);
    public List<Customer> GetAll();
    public Customer GetById(String customerId);
    public Customer Update(String customerId);
    public Customer PartialUpdate(String customerId);
    public boolean Delete(String customerId);
    public boolean LogicalDelete(String customerId);
}