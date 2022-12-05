package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.Exercise;
import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.CustomExerciseRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomExerciseController {

    @Autowired
    CustomExerciseRepo customExerciseRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/exercise/view-all")
    public String showAllCustomExercise(Model model) {
        model.addAttribute("custom_exercises", customExerciseRepo.findAll());
        return "exercise/view-all";
    }


    @GetMapping("/exercise/create")
    public String createCustomExercise(Model model) {
            Exercise exercise = new Exercise();
            User user = userRepo.getReferenceById(1L);
            exercise.setUser(user);
            model.addAttribute("exercise",exercise);
        return "exercise/create";
    }

     @PostMapping("/exercise/create")
     public String createCustomExercise(@ModelAttribute Exercise exercise){
            User user= exercise.getUser();
            exercise.setUser(user);
//            customExerciseRepo.save(exercise);
          return "exercise/create";
     }


}
