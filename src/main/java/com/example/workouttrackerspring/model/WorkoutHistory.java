package com.example.workouttrackerspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WorkoutHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long timestamp;
    @OneToOne(cascade = CascadeType.ALL)
    private Workout workout;
//    @ManyToOne
//    private User user;
}
