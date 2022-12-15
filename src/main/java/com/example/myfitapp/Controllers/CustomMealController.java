package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.CustomMeal;
import com.example.myfitapp.Repos.CustomMealsRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomMealController {

    @Autowired
    CustomMealsRepo customMealRepo;

    @Autowired
    UserRepo userRepo;
    //view all meals
    @GetMapping("/show-custom-meals")
    public String showAllCustomMeals(Model model) {
        model.addAttribute("custom_meals", customMealRepo.findAll());
        return "custom-meals/show-all-custom-meals";
    }
    //show create meal form
    @GetMapping("/create-custom-meal")
    public String createCustomMeal(Model model) {
        model.addAttribute("custom_meal", new CustomMeal());
        return "/custom-meals/create-custom-meal";
    }
    //post create meal data
    @PostMapping("/create-custom-meal")
    public String createCustomMeal(@ModelAttribute CustomMeal customMeal){
        customMealRepo.save(customMeal);
        return "redirect:/show-custom-meals";
    }

    @GetMapping("/update-custom-meal/{id}")
    public String updateCustomMeal(@PathVariable long id, Model model){
        CustomMeal mealToUpdate = customMealRepo.getReferenceById(id);
        model.addAttribute("custom_meal", mealToUpdate);
        return "/custom-meals/update-custom-meal";
    }
    //post updated meal
    @PostMapping("/update-custom-meal")
    public String updateCustomMeal(@ModelAttribute CustomMeal updatedMeal){
        customMealRepo.save(updatedMeal);
        return "redirect:show-custom-meals";
    }

    @PostMapping("/delete-meal/{id}")
    public String deleteCustomMeal(@PathVariable long id){
        CustomMeal mealToDelete = customMealRepo.getReferenceById(id);
        customMealRepo.delete(mealToDelete);
        return "redirect:/show-custom-meals";
    }


}
