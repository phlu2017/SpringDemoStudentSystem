package com.example.students.system.service;

import com.example.students.system.domain.Student;
import com.example.students.system.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentEntityToDtoServiceImpl{
    @Autowired
    ModelMapper modelMapper;


    public List<StudentDto> convertAll(List<Student> list) {
         return list.stream().map(e -> convertSingleObject(e)).collect(Collectors.toList());
    }

    public StudentDto convertSingleObject(Student obj) {
        return  modelMapper.map(obj, StudentDto.class);
    }
}
