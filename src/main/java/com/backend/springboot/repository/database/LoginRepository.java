package com.backend.springboot.repository.database;


import com.backend.springboot.model.entities.User;
import com.backend.springboot.repository.interfacedatabase.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements ILoginRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsername(String username) {
        String sql = "SELECT id, username, password FROM [User] WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { username }, new BeanPropertyRowMapper<>(User.class));
    }

}
