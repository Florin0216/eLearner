package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "domain", nullable = false)
    private String domain;

    @Column(name = "educational_stage", nullable = false)
    private String educationalStage;

    @Column(name = "grade", nullable = false)
    private String grade;

    @OneToMany(mappedBy = "course")
    private List<Material> materials;
}
