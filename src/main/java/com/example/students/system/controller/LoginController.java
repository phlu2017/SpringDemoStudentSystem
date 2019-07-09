package com.example.students.system.controller;

import com.example.students.system.domain.User;
import com.example.students.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.students.system.dao.UserDao;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView  Login() {
        ModelAndView view = new ModelAndView("Login");
        return view;
    }

    @PostMapping(value = "/login")
    public ModelAndView authenticateUser ( HttpServletRequest request){
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        ModelAndView view = null;
        if(!userService.verifyUser(account, pwd)){
            view = new ModelAndView("Login");
        } else{
            view = new ModelAndView("main");

            view.addObject("message", account);
        }
        return view;
    }


}
