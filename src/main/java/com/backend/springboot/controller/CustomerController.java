package com.backend.springboot.controller;

import com.backend.springboot.model.entities.Customer;
import com.backend.springboot.model.reponse.ServiceReponse;
import com.backend.springboot.service.interfacehandle.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>>  list(){
        var result = iCustomerService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceReponse> save(@RequestBody Customer customer){
        ServiceReponse serviceReponse = new ServiceReponse();
        int result = iCustomerService.save(customer);
        if (result == 1){
            serviceReponse.setMessage("item save with success!");
        }
        return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceReponse> update(@RequestBody Customer customer){
        ServiceReponse serviceReponse = new ServiceReponse();
        int result = iCustomerService.update(customer);
        if (result == 1){
            serviceReponse.setMessage("item update with success!");
        }
        return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceReponse> update(@PathVariable int id){
        ServiceReponse serviceReponse = new ServiceReponse();
        int result = iCustomerService.deleteById(id);
        if (result == 1){
            serviceReponse.setMessage("item removed with success!");
        }
        return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    }
}
