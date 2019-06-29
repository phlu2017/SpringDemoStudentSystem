package com.example.students.system.service;

import com.example.students.system.domain.Course;
import com.example.students.system.dto.CourseDto;

import java.util.Set;

public interface SutdentService {

    Set<CourseDto> findStudentTakenCourses(long id);
    Set<CourseDto> findStudentCurrentErolledCourses(long id, String term);

}
