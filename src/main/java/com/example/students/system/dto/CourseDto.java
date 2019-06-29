package com.example.students.system.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

// model mapping
@Component
@Data
public class CourseDto {
    long id;
    String name;

    public CourseDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDto() {
    }
    
    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}