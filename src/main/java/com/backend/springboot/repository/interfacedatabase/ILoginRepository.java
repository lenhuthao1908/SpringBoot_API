package com.backend.springboot.repository.interfacedatabase;

import com.backend.springboot.model.entities.User;

public interface ILoginRepository {

    public User findByUsername(String username);
}
