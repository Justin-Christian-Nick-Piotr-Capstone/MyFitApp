package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.CustomExercise;
import com.example.myfitapp.Models.CustomMeal;
import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.CustomMealsRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomMealController {

    @Autowired
    CustomMealsRepo customMealRepo;

    @Autowired
    UserRepo userRepo;
    //view all meals
    @GetMapping("/show-custom-meals")
    public String showAllCustomExercise(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CustomMeal> customMealList = customMealRepo.findAll();
        for (int i = 0; i < customMealList.size(); i++) {
            CustomMeal customMeal = customMealList.get(i);
            if (customMeal.getUser().getId() != loggedInUser.getId()) {
                customMealList.remove(i);
                i-=1;
//                System.out.println("Custom exercise " + customExercise.getId() + " removed.");
            }
//            System.out.println("----------------------------------------------------");
        }
        model.addAttribute("custom_meals", customMealList);
        return "/custom-meals/show-all-custom-meals";
    }
    //show create meal form
    @GetMapping("/create-custom-meal")
    public String createCustomMeal(Model model) {
        CustomMeal customMeal = new CustomMeal();
        customMeal.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("custom_meal", customMeal);
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
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
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/custom-meals/update-custom-meal";
    }

//    @GetMapping("/update-custom-exercise/{id}")
//    public String updateCustomExercise(@PathVariable long id, Model model){
//        CustomExercise exerciseToUpdate = customExerciseRepo.getReferenceById(id);
//        model.addAttribute("custom_exercise", exerciseToUpdate);
//        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        customExerciseRepo.save(exerciseToUpdate);
//        return "/custom-exercises/update-custom-exercise";
//    }
    //post updated meal
    @PostMapping("/update-custom-meal")
    public String updateCustomMeal(@ModelAttribute CustomMeal updatedMeal){
        customMealRepo.save(updatedMeal);
        return "redirect:show-custom-meals";
    }

    @PostMapping("/delete-custom-meal/{id}")
    public String deleteCustomMeal(@PathVariable long id){
        CustomMeal mealToDelete = customMealRepo.getReferenceById(id);
        customMealRepo.delete(mealToDelete);
        return "redirect:/show-custom-meals";
    }


}
