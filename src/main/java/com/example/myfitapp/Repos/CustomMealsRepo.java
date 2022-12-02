package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.CustomMeals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomMealsRepo extends JpaRepository<CustomMeals, Long> {
}
