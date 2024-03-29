package com.example.students.system.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
//@Table(name="student") @Table(name="BOOKS", schema="PUBLISHING")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = IDENTITY)
    @JsonProperty("stu_id")
    @Column(name = "stu_id", updatable = false, nullable = false)
    private long id;

    @JsonProperty("stulastname")
    @Column(name="stulastname")
    private String lastname;

    @JsonProperty("stufirstname")
    @Column(name="stufirstname")
    private String firstname;
//    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
//    private Set<Course> courses;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "grade",
            joinColumns = @JoinColumn(name = "stu_id", referencedColumnName = "stu_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    )
//    @JoinTable, or even @JoinColumn isn’t required: JPA will generate the table and column names for us.
//            However, the strategy JPA uses won’t always match the naming conventions we use.
//    Hence the possibility to configure table and column names.
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", courses=" + courses +
                '}';
    }
}
