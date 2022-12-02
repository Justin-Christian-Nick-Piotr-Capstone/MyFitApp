package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.CustomExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomExerciseRepo extends JpaRepository<CustomExercises, Long> {

}
