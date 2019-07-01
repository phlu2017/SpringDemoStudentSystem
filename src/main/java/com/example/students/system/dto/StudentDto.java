package com.example.students.system.dto;

import com.example.students.system.domain.Grade;
import org.springframework.stereotype.Component;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

// model mapping
@Component
@Data
public class StudentDto {
    long id;
    String firstName;
    String lastName;
    Set<Grade> takenCourseAndGrade = new HashSet<>();

    public StudentDto() {
    }

    public StudentDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void SetTakenCourseAndGrade(Set<Grade> gradeSet){
        gradeSet.forEach(e -> takenCourseAndGrade.add(e));
    }

//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
}
