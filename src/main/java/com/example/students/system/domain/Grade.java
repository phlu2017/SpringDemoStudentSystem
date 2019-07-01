package com.example.students.system.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
@Data
@Entity
//@Table(name="student") @Table(name="BOOKS", schema="PUBLISHING")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = IDENTITY)
    @JsonProperty("g_id")
    @Column(name = "g_id", updatable = false, nullable = false)
    private long id;
//
//    @JsonProperty("c_id")
//    @Column(name="c_id")
//    private long c_id;
//
//    @JsonProperty("stu_id")
//    @Column(name="stu_id")
//    private long stu_id;

    @ManyToOne
    @JoinColumn(name="c_id")
    private Course course;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="stu_id")
    private Student student;

    @Column(name = "grade")
    @JsonProperty("grade")
    private String grade;

    @Column(name = "time")
    @JsonProperty("time")
    private String time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return id == grade1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, student, time);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", course=" + course.toString() +
                ", student=" + student.toString() +
                ", grade='" + grade + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
