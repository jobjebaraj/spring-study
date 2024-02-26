package com.example.study.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.util.Objects;

@Data
@Entity
@Table(name="Person" ,schema="demo_schema")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "demo_schema.person_seq", allocationSize = 1)
    @Column(name="id")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="DEPT")
    private String dept;

    @Column(name="DESIGN")
    private String design;


}
