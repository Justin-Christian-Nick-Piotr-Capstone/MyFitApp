package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.CustomExercise;
import com.example.myfitapp.Repos.CustomExerciseRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomExerciseController {

    @Autowired
    CustomExerciseRepo customExerciseRepo;

    @Autowired
    UserRepo userRepo;

    //show list of all custom exercises
    @GetMapping("/show-custom-exercise")
    public String showAllCustomExercise(Model model) {
        model.addAttribute("custom_exercises", customExerciseRepo.findAll());
        return "/custom-exercises/show-all-custom-exercises";
    }
    //create custom exercise form
    @GetMapping("/create-custom-exercise")
    public String createCustomExercise(Model model) {
        model.addAttribute("custom_exercise", new CustomExercise());
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
