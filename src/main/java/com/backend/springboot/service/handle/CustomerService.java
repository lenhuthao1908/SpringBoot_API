package com.backend.springboot.service.handle;

import com.backend.springboot.model.entities.Customer;
import com.backend.springboot.repository.interfacedatabase.ICustomerRepository;
import com.backend.springboot.service.interfacehandle.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll(){
        List<Customer> list;
        try{
            list = iCustomerRepository.findAll();
        }catch (Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int save(Customer customer){
        int row;
        try{
            row = iCustomerRepository.save(customer);
        }catch (Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(Customer customer){
        int row;
        try{
            row = iCustomerRepository.update(customer);
        }catch (Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int deleteById(int id){
        int row;
        try{
            row = iCustomerRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
        return row;
    }
}
