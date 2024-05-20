package com.example.workouttrackerspring.repository;

import com.example.workouttrackerspring.model.ExerciseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseInfoRepository extends JpaRepository<ExerciseInfo, Long> {
    void deleteById(long id);
}
