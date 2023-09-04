package com.backend.springboot.service.interfacehandle;

import com.backend.springboot.model.entities.User;

public interface ILoginService {
    public boolean login(String username, String password);

    public String getRole(String username);
}
