package com.example.students.system.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Objects;
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

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "grade",
//            joinColumns = @JoinColumn(name = "stu_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "c_id", referencedColumnName = "id"))
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Grade> gradeSet = new HashSet<Grade>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
