package com.example.students.system.dao;

import com.example.students.system.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
