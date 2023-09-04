package com.backend.springboot.repository.interfacedatabase;

import com.backend.springboot.model.entities.User;

import java.util.List;

public interface IUserRepository {
    public List<User> findAll();
    public int save(User user);

}
