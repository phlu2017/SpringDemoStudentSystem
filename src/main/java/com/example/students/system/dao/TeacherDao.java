package com.example.students.system.dao;

import com.example.students.system.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher, Long> {
    public List<Teacher> findByTIdIgnoreCase( String Tid);

}
