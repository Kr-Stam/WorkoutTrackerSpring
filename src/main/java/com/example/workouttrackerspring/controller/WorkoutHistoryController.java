package com.example.workouttrackerspring.controller;

import com.example.workouttrackerspring.model.WorkoutHistory;
import com.example.workouttrackerspring.repository.WorkoutHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workoutHistory")
@RequiredArgsConstructor
public class WorkoutHistoryController {

    private final WorkoutHistoryRepository workoutHistoryRepository;

    @GetMapping
    public ResponseEntity<List<WorkoutHistory>> getWorkoutHistory(){
        return new ResponseEntity<>(workoutHistoryRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public void addWorkoutHistory(
            @RequestBody WorkoutHistory workoutHistory
    ){
        workoutHistoryRepository.save(workoutHistory);
    }
    @DeleteMapping("/{id}")
    public void deleteWorkoutHistory(
            @PathVariable long id
    ){
        workoutHistoryRepository.deleteById(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutHistory> getWorkoutHistoryDetails(
            @PathVariable long id
    ){
        Optional<WorkoutHistory> result = workoutHistoryRepository.findById(id);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}")
    public void updateWorkoutHistory(
            @PathVariable long id,
            @RequestBody WorkoutHistory workoutHistory
    ){
        if(workoutHistory.getId() != id){
            workoutHistory.setId(id);
        }
        workoutHistoryRepository.save(workoutHistory);
    }
}
