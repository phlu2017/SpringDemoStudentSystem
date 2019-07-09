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
public class User {
    @Id
    @JsonProperty("account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="`id`")
    private String id;


    @JsonProperty("pwd")
    @Column(name="`pwd`")
    private String pwd;
}
