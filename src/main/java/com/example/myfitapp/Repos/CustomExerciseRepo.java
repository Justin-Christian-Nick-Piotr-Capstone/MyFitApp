package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.CustomExercise;
import com.example.myfitapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomExerciseRepo extends JpaRepository<CustomExercise, Long> {
    List<CustomExercise> findCustomExerciseByUser(User user);
}
