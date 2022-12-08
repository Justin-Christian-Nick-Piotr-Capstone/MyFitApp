package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.CustomMeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomMealsRepo extends JpaRepository<CustomMeal, Long> {
}
