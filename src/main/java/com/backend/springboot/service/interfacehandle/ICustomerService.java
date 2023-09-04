package com.backend.springboot.service.interfacehandle;

import com.backend.springboot.model.entities.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();

    public int save(Customer customer);

    public int update(Customer customer);

    public int deleteById(int id);
}
