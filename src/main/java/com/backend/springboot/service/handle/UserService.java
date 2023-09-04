package com.backend.springboot.service.handle;

import com.backend.springboot.model.entities.User;
import com.backend.springboot.repository.interfacedatabase.IUserRepository;
import com.backend.springboot.service.interfacehandle.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll(){
        List<User> list;
        try{
            list = iUserRepository.findAll();
        }catch (Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int save(User user){
        int row;
        try{
            row = iUserRepository.save(user);
        }catch (Exception e){
            throw e;
        }
        return row;
    }
}
