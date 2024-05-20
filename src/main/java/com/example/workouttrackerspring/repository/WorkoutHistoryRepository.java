package com.example.workouttrackerspring.repository;

import com.example.workouttrackerspring.model.WorkoutHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutHistoryRepository extends JpaRepository<WorkoutHistory, Long> {
//    List<WorkoutHistory> findAllByUserId(long userId);
    void deleteById(long id);
}
