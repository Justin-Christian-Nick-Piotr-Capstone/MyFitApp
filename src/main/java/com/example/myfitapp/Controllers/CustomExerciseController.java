package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.CustomExercise;
import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.CustomExerciseRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomExerciseController {

    @Autowired
    CustomExerciseRepo customExerciseRepo;

    @Autowired
    UserRepo userRepo;


    //show list of all custom exercises
    @GetMapping("/show-custom-exercise")
    public String showAllCustomExercise(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CustomExercise> customExerciseList = customExerciseRepo.findAll();
        for (int i = 0; i < customExerciseList.size(); i++) {
            CustomExercise customExercise = customExerciseList.get(i);
            if (customExercise.getUser().getId() != loggedInUser.getId()) {
                customExerciseList.remove(i);
                i-=1;
                System.out.println("Custom exercise " + customExercise.getId() + " removed.");
            }
            System.out.println("----------------------------------------------------");
        }
        model.addAttribute("custom_exercises", customExerciseList);
        return "/custom-exercises/show-all-custom-exercises";
    }



    //create custom exercise form
    @GetMapping("/create-custom-exercise")
    public String createCustomExercise(Model model) {
        CustomExercise customExercise = new CustomExercise();
        customExercise.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("custom_exercise", customExercise);
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/custom-exercises/create-custom-exercise";
    }
    //post custom exercise data
     @PostMapping("/create-custom-exercise")
     public String createCustomExercise(@ModelAttribute CustomExercise customExercise){
        customExerciseRepo.save(customExercise);
        return "redirect:/show-custom-exercise";
     }
     //update custom exercise
    @GetMapping("/update-custom-exercise/{id}")
    public String updateCustomExercise(@PathVariable long id, Model model){
        CustomExercise exerciseToUpdate = customExerciseRepo.getReferenceById(id);
        model.addAttribute("custom_exercise", exerciseToUpdate);
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        customExerciseRepo.save(exerciseToUpdate);
        return "/custom-exercises/update-custom-exercise";
    }
    //post custom exercise
    @PostMapping("/update-custom-exercise")
    public String updateCustomExercise(@ModelAttribute CustomExercise customExercise){
        customExerciseRepo.save(customExercise);
        return "redirect:/show-custom-exercise";
    }
    @PostMapping("/delete-custom-exercise/{id}")
    public String deleteCustomExercise(@PathVariable long id){
        CustomExercise exerciseToDelete = customExerciseRepo.getReferenceById(id);
        customExerciseRepo.delete(exerciseToDelete);
        return "redirect:/show-custom-exercise";
     }

}
