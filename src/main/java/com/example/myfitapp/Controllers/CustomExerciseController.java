//package com.example.myfitapp.Controllers;
//
//
//import com.example.myfitapp.Repos.CustomExerciseRepo;
//import com.example.myfitapp.Repos.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class CustomExerciseController {
//
//    @Autowired
//    CustomExerciseRepo customExerciseRepo;
//
//    @Autowired
//    UserRepo userRepo;
//
//    @GetMapping("/exercise/view-all")
//    public String showAllCustomExercise(Model model) {
//        model.addAttribute("custom_exercises", customExerciseRepo.findAll());
//        return "exercise/view-all";
//    }
//
//
//    @GetMapping("/exercise/create")
//    public String createCustomExercise(Model model) {
//
//            model.addAttribute("custom-exercise");
//        return "exercise/create";
//    }
//
//     @PostMapping("/exercise/create")
//     public String createCustomExercise(){
//
////            customExerciseRepo.save(exercise);
//          return "exercise/create";
//     }
//
//     @GetMapping
//    public String deleteCustomExercise(){
//        return "exercise/delete";
//     }
//
//}
