package com.example.students.system.dao;

import com.example.students.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    public List<User> findByAccountIgnoreCase(String account);
}
