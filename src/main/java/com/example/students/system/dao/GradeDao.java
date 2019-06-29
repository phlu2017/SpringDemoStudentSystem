package com.example.students.system.dao;

import com.example.students.system.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeDao extends JpaRepository<Grade, Long> {
}
