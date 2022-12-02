package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.UserRepo;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String landingPage() {
        return "/homepage";
    }

    // Read functionality for users.
    @GetMapping("/show-all-users")
    public String showAllUsers(Model model) {
        List<User> userList = new ArrayList<>();
        model.addAttribute("users", userRepo.findAll());
        System.out.println(userRepo.findAll());
        return "/users/viewAllUsers";
    }

    // Create functionality for users.
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/";
    }

    // Update functionality for users.
    @GetMapping("/update-user/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        User userToUpdate = userRepo.getReferenceById(id);
        model.addAttribute("user", userToUpdate);
        return "/users/updateUser";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User updatedUser) {
        userRepo.save(updatedUser);
        return "redirect:/";
    }
}
