package com.example.workouttrackerspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int type;
    private int reps;
    private int value;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("set")
    private List<PR> prs;
}
