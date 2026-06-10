package com.store.videogames.modules.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}