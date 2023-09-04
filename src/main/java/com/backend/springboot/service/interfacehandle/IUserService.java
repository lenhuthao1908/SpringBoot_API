package com.backend.springboot.service.interfacehandle;

import com.backend.springboot.model.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    public int save(User user);
}
