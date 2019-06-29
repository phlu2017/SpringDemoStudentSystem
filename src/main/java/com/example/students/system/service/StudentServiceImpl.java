package com.example.students.system.service;

import com.example.students.system.dao.StudentDao;
import com.example.students.system.dto.CourseDto;
import com.example.students.system.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class StudentServiceImpl implements SutdentService{
    @Autowired
    StudentDao studentDao;

    @Override
    public Set<CourseDto> findStudentTakenCourses(long id) {
        studentDao.
        return null;
    }

    @Override
    public Set<CourseDto> findStudentCurrentErolledCourses(long id, String term) {
        return null;
    }
}
