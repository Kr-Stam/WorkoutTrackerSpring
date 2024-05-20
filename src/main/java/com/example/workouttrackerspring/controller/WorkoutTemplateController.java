package com.example.workouttrackerspring.controller;

import com.example.workouttrackerspring.model.WorkoutTemplate;
import com.example.workouttrackerspring.repository.WorkoutTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workoutTemplates")
@RequiredArgsConstructor
public class WorkoutTemplateController {

    private final WorkoutTemplateRepository workoutTemplateRepository;

    @GetMapping
    public ResponseEntity<List<WorkoutTemplate>> getWorkoutTemplates(){
        return new ResponseEntity<>(workoutTemplateRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public void addWorkoutTemplate(
            @RequestBody WorkoutTemplate workoutTemplate
    ){
        workoutTemplateRepository.save(workoutTemplate);
    }
    @DeleteMapping("/{id}")
    public void deleteWorkoutTemplate(
            @PathVariable long id
    ){
        workoutTemplateRepository.deleteById(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutTemplate> getWorkoutTemplateDetails(
            @PathVariable long id
    ){
        Optional<WorkoutTemplate> result = workoutTemplateRepository.findById(id);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}")
    public void updateWorkoutTemplate(
            @PathVariable long id,
            @RequestBody WorkoutTemplate workoutTemplate
    ){
        if (workoutTemplate.getId() != id){
            workoutTemplate.setId(id);
        }
        workoutTemplateRepository.save(workoutTemplate);
    }
}
