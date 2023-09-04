package com.backend.springboot.controller;

import com.backend.springboot.model.dto.LoginDto;
import com.backend.springboot.model.entities.User;
import com.backend.springboot.model.reponse.ServiceReponse;
import com.backend.springboot.service.interfacehandle.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @PostMapping("/test")
    public ResponseEntity<ServiceReponse> login(@RequestBody LoginDto loginDto){
        ServiceReponse serviceReponse = new ServiceReponse();
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        boolean result = iLoginService.login(username, password);

        if (result) {
            serviceReponse.setMessage("login success!");
        }else {
            serviceReponse.setMessage("login error!");
        }
        return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    }
}
