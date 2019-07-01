package com.example.students.system.dao;

import com.example.students.system.domain.Grade;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.GradeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface StudentDao extends JpaRepository<Student, Long> {

    //IgnoreCase for Case Insensitive Queries
    List<Student> findAll();

    List<Student> findByLastnameAndFirstname(String last, String first);

    void deleteById(long stu_id);

    Student findOneById(long stu_id);


//    @Query(value = "SELECT s FROM studnet s LEFT JOIN grade g ON g.stu_id = s.stu_id " +
//            "WHERE g.g_id = :id")
    //@Query(value = "SELECT s FROM Student s WHERE s.id = :id")
    @Query(value = "SELECT s FROM Student s Where id = 4")
    public Student findStudentTakenGrade(@Param("id") long id);

//    @Query(value = "SELECT s FROM Grade s WHERE s.stu_id = 0")
//    public Grade findStudentTakenGrade2(@Param("id") long id);
    //public Student findByStuIdIgnoreCase(String stuId);


}
