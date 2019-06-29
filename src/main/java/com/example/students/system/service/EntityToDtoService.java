package com.example.students.system.service;

import com.example.students.system.domain.Student;
import com.example.students.system.dto.StudentDto;

import java.util.List;

public interface EntityToDtoService {

    public List<Object> convertAll(List<Object> list);
    public Object convertSingleObject(Object obj);
}
    //In a web application with ideal design, place the @Transaction annotation at the service that is invoked by the controller. In an other not so ideal web application where the controller invoke more than one service method (and both should must been handled in the same transaction), you have to place the @Transaction annotation at the controller method.