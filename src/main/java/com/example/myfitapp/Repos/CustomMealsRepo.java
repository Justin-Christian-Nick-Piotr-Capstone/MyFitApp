package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.CustomExercise;
import com.example.myfitapp.Models.CustomMeal;
import com.example.myfitapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomMealsRepo extends JpaRepository<CustomMeal, Long> {
    List<CustomMeal> findCustomMealByUser(User user);
}
