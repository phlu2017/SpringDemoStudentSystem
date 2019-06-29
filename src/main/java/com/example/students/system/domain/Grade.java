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
public class Grade {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = IDENTITY)
    @JsonProperty("g_id")
    @Column(name = "g_id", updatable = false, nullable = false)
    private long id;

    @JsonProperty("c_id")
    @Column(name="c_id")
    private long c_id;

    @JsonProperty("s_id")
    @Column(name="s_id")
    private long s_id;

    @Column(name = "time")
    private String time;

}
