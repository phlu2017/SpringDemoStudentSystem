package com.example.students.system.service;

import com.example.students.system.dao.UserDao;
import com.example.students.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public Boolean verifyUser(String account, String pwd) {
        User verifyUser = userDao.findOneById(account);
        if(verifyUser!=null)
            System.out.println(verifyUser.getPwd());
        if(verifyUser==null || !verifyUser.getPwd().equals(pwd))
            return false;
        return true;
    }
}
