package com.backend.springboot.controller;


import com.backend.springboot.model.entities.User;
import com.backend.springboot.model.reponse.ServiceReponse;
import com.backend.springboot.service.interfacehandle.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        var result = iUserService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceReponse> save(@RequestBody User user){
        ServiceReponse serviceReponse = new ServiceReponse();
        int result = iUserService.save(user);
        if (result == 1){
            serviceReponse.setMessage("item save with success!");
        }
        return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    }
}
