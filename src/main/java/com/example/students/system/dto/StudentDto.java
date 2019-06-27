package com.example.students.system.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

// model mapping
@Component
@Data
public class StudentDto {
    long id;
    String firstName;
    String lastName;


    public StudentDto() {
    }

    public StudentDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
