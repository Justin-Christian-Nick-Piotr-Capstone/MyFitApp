package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.CustomMeal;
import com.example.myfitapp.Repos.CustomMealsRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CustomMealController {

    @Autowired
    CustomMealsRepo customMealRepo;

    @Autowired
    UserRepo userRepo;
    //view all meals
    @GetMapping("/show-custom-meal")
    public String showAllCustomMeals(Model model) {
        model.addAttribute("custom_exercises", customMealRepo.findAll());
        return "show-custom-meal";
    }
    //show create meal form
    @GetMapping("/create-meal")
    public String createCustomMeal(Model model) {
        model.addAttribute("exercise", new CustomMeal());
        return "create-meal";
    }
    //post create meal data
    @PostMapping("/create-meal")
    public String createCustomMeal(@ModelAttribute CustomMeal customMeal){
            customMealRepo.save(customMeal);
            return "/create-meal";
    }

    @GetMapping("/update-meal/{id}")
    public String updateCustomMeal(@PathVariable long id, Model model){
        CustomMeal mealToUpdate = customMealRepo.getReferenceById(id);
        model.addAttribute("custom-meal", mealToUpdate);
        return "/updateMEal";
    }
    //post updated meal
    @PostMapping("/update-meal")
    public String updateCustomMeal(@ModelAttribute CustomMeal updatedMeal){
        customMealRepo.save(updatedMeal);
        return "redirect:show-custom-meal";
    }

    @PostMapping("/delete-meal/{id}")
    public String deleteCustomMeal(@PathVariable long id){
        CustomMeal mealToDelete = customMealRepo.getReferenceById(id);
        customMealRepo.delete(mealToDelete);
        return "redirect:/show-custom-meal";
    }


}
