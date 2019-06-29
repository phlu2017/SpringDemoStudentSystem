package com.example.students.system.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

// model mapping
@Component
@Data
public class GradeDto {
    long id;
    long course_id;
    long student_id;
    String term;

    public GradeDto(long id, long course_id, long stduent_id, String term) {
        this.id = id;
        this.course_id = course_id;
        this.student_id = stduent_id;
        this.term = term;
    }

    public GradeDto() {
    }

    @Override
    public String toString() {
        return "GradeGto{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", stduent_id=" + student_id +
                ", term='" + term + '\'' +
                '}';
    }
}
