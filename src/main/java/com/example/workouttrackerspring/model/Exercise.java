package com.example.workouttrackerspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(optional = true)
    @JsonIgnoreProperties("exerciseInfo")
    ExerciseInfo exerciseInfo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Set> sets;
}
