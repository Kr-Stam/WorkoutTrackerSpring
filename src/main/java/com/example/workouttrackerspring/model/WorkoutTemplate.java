package com.example.workouttrackerspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WorkoutTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Workout workout;
//    @ManyToOne
//    private User user;
}
