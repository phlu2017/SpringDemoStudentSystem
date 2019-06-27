package com.example.students.system.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
//@Table(name="student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("tId")
    @Column(name="`t_id`")
    private String tId;

    @JsonProperty("tlastname")
    @Column(name="`tlastname`")
    private String tlastname;

    @JsonProperty("tfirstname")
    @Column(name="`tfirstname`")
    private String tfirstname;


}
