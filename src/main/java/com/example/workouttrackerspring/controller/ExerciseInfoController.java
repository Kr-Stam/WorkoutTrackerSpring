package com.example.workouttrackerspring.controller;

import com.example.workouttrackerspring.model.ExerciseInfo;
import com.example.workouttrackerspring.repository.ExerciseInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exerciseInfo")
@RequiredArgsConstructor
public class ExerciseInfoController {

    private final ExerciseInfoRepository exerciseInfoRepository;

    @GetMapping
    public ResponseEntity<List<ExerciseInfo>> getAllExercises(){
        return new ResponseEntity<>(exerciseInfoRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public void addExercise(
            @RequestBody ExerciseInfo exerciseInfo
    ){
        System.out.println(exerciseInfo);
        exerciseInfoRepository.save(exerciseInfo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseInfo> getExerciseDetails(
            @PathVariable long id
    ){
        var result = exerciseInfoRepository.findById(id);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteExerciseInfo(
            @PathVariable long id
    ){
        exerciseInfoRepository.deleteById(id);
    }
    @PostMapping("/{id}")
    public void updateExerciseInfo(
            @PathVariable long id,
            @RequestBody ExerciseInfo exerciseInfo
    ){
        if(exerciseInfo.getId() != id){
            exerciseInfo.setId(id);
        }
        exerciseInfoRepository.save(exerciseInfo);
    }
}
