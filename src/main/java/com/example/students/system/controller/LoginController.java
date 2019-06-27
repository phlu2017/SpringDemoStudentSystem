package com.example.students.system.controller;

import com.example.students.system.domain.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.students.system.dao.UserDao;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    UserDao user;

    @RequestMapping("/home")
    public String hello() {
        return "Welcome to Websparrow";
    }

    @PostMapping("/what")
    public ResponseEntity authenticateUser ( @RequestParam("account") String account, @RequestParam("pwd") String pwd){
        if(account==null || account.length()==0)
            return new ResponseEntity("User info wrong",HttpStatus.BAD_REQUEST);

        List<User> visiter = user.findByAccountIgnoreCase(account);

        if(visiter.equals(pwd))
            return new ResponseEntity("hello",HttpStatus.OK);
        return new ResponseEntity("User info wrong",HttpStatus.BAD_REQUEST);
    }


}
