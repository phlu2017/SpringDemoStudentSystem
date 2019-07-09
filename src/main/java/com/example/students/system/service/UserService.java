package com.example.students.system.service;

import com.example.students.system.dao.UserDao;
import com.example.students.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    Boolean verifyUser(String account, String pwd);
}
