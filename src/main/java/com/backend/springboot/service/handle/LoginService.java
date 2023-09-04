package com.backend.springboot.service.handle;

import com.backend.springboot.model.entities.User;
import com.backend.springboot.repository.interfacedatabase.ILoginRepository;
import com.backend.springboot.service.interfacehandle.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private ILoginRepository iLoginRepository;


    public boolean login(String username, String password) {
        User user = iLoginRepository.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matchesPassword = passwordEncoder.matches(password, user.getPassword());
        if (user != null && matchesPassword==true) {
            return true;
        }
        return false;
    }

    @Override
    public String getRole(String username) {
        User user = iLoginRepository.findByUsername(username);
        return user != null ? user.getRole() : null;
    }


}
