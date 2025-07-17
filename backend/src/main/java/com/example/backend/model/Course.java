package com.example.backend.model;

import com.example.backend.model.enums.Domain;
import com.example.backend.model.enums.EducationalStage;
import com.example.backend.model.enums.Grade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "domain", nullable = false)
    private Domain domain;

    @Enumerated(EnumType.STRING)
    @Column(name = "educational_stage", nullable = false)
    private EducationalStage educationalStage;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", nullable = false)
    private Grade grade;

    @OneToMany(mappedBy = "course")
    private List<Material> materials;

    @JsonBackReference
    @ManyToMany(mappedBy = "courses")
    private Set<User> users;
}
