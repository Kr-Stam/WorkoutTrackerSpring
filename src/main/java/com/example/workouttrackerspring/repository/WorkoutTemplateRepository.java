package com.example.workouttrackerspring.repository;

import com.example.workouttrackerspring.model.WorkoutTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutTemplateRepository extends JpaRepository<WorkoutTemplate, Long> {
    //    List<WorkoutTemplate> findAllByUserId(long userId);
    void deleteById(long id);
}
