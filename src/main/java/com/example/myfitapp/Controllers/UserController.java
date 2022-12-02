package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String landingPage() {
        return "/homepage";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/test";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/homepage";
    }
}
