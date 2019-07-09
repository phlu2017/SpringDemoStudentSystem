package com.example.students.system.controller;

import com.example.students.system.dto.StudentDto;
import com.example.students.system.service.StudentService;
import com.example.students.system.service.StudentServiceImpl;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController  {
    @Autowired
    StudentService studentService;

    @PostMapping("/findstudent")
    public ModelAndView studentsView(HttpServletRequest request ){
        String user = (String) request.getAttribute("message");
        if(user==null) user = (String)request.getSession().getAttribute("message");

        String lastName = (String) request.getParameter("studentLastName");
        String firstName = (String) request.getParameter("studentFirstName");
        System.out.println(user);
        System.out.println(lastName);
        System.out.println(firstName);
        ModelAndView view = new ModelAndView("main");
        List<StudentDto> list = studentService.findStudentByLastNameAndFirstName(lastName, firstName);
        if(list!=null){
            System.out.println(list.size());
            view.addObject("lists", list);
        }

        //list.forEach( s->System.out.println(s.toString()) );

        view.addObject("message", user);
        return view;
    }
}
