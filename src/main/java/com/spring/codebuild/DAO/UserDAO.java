package com.spring.codebuild.DAO;

import com.spring.codebuild.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User showUser(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE Id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }

    public User checkUser(String email) {
        return jdbcTemplate.query("SELECT * FROM users WHERE Email=?", new Object[]{email},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public void regUser(Map<String, Object> user) {
        jdbcTemplate.update("INSERT INTO users (Email, Password, Name, Version) VALUES(?, ?, ?, ?", user.get("Email"),
                user.get("Password"), user.get("Name"), user.get("Version"));
    }
}
