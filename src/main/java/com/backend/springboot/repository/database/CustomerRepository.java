package com.backend.springboot.repository.database;

import com.backend.springboot.model.entities.Customer;
import com.backend.springboot.repository.interfacedatabase.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import java.io.ObjectStreamClass;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll(){
        String SQL = "SELECT [customername]\n" +
                "      ,[customeraddress]\n" +
                "      ,[mobile] FROM Customer WHERE status = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Customer.class));
    }
//    public List<Customer> findAll() {
//        String SQL = "SELECT [customername] FROM Customer WHERE status = 1";
//        return jdbcTemplate.queryForList(SQL, Object.class);
//    }

    @Override
    public int save(Customer customer){
        String SQL = "INSERT INTO Customer VALUES(?,?,?,1)";
        return jdbcTemplate.update(SQL, new Object[]{
                customer.getCustomername(),
                customer.getCustomeraddress(),
                customer.getMobile()
        });
    }

    @Override
    public int update(Customer customer){
        String SQL = "UPDATE Customer SET customername = ?, customeraddress = ?, mobile = ?, status = ? where customerid = ?";
        return jdbcTemplate.update(SQL, new Object[]{
                customer.getCustomername(),
                customer.getCustomeraddress(),
                customer.getMobile(),
                customer.getStatus(),
                customer.getCustomerid()
        });
    }

    @Override
    public int deleteById(int id){
        String SQL = "UPDATE Customer SET status=0 WHERE customerid = ?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
