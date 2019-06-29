package com.example.students.system.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
@Data
@Entity
//@Table(name="student") @Table(name="BOOKS", schema="PUBLISHING")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @JsonProperty("c_id")
    @Column(name = "c_id", updatable = false, nullable = false)
    private long id;

    @JsonProperty("cname")
    @Column(name="cname")
    private String name;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
