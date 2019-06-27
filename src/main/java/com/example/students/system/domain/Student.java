package com.example.students.system.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@Table(name="student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("stu_id")
    @Column(name = "stu_id", updatable = false, nullable = false)
    private Integer id;

    @JsonProperty("stulastname")
    @Column(name="`stulastname`")
    private String lastname;

    @JsonProperty("stufirstname")
    @Column(name="`stufirstname`")
    private String firstname;

}
