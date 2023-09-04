package com.backend.springboot.repository.database;

import com.backend.springboot.model.entities.Customer;
import com.backend.springboot.model.entities.User;
import com.backend.springboot.repository.interfacedatabase.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String SQL = "SELECT [username] FROM [User]";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int save(User user) {
        String SQL = "insert into [User]\n" +
                "values(?, ?, ?)";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String name = user.getUsername();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        return jdbcTemplate.update(SQL, new Object[]{
                name,
                hashedPassword,
                "user"
        });
    }
}
