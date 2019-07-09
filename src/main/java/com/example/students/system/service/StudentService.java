package com.example.students.system.service;

import com.example.students.system.domain.Course;
import com.example.students.system.domain.Grade;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.CourseDto;
import com.example.students.system.dto.GradeDto;
import com.example.students.system.dto.StudentDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface StudentService {

    //List<GradeDto> findStudentTakenGrade(long id);
    List<StudentDto> findAllStudent();

    List<StudentDto> findStudentByLastNameAndFirstName(String firstName, String lastName);

    StudentDto findSingleStudentbyId(long id);

    StudentDto createNewStudent(StudentDto studentDto);

    StudentDto deleteStudentbyId(long id);

    StudentDto updateStudentbyId(long id, String firstName, String lastName);


    // Set<CourseDto> findStudentCurrentErolledCourses(long id, String term);
    List<StudentDto> testQuery(long id);
    List<Course> fetchEmpDeptDataLeftJoin();
}
