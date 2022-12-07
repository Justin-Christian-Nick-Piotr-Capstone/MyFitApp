package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
        String password = user.getPassword();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepo.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "/users/login";
    }

    // Login functionality
    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        User user = userRepo.findByUsername(username);
        if (userRepo.findByUsername(username) == null) {
            System.out.println("No user with that username found in the database.");
        }
        else if (BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("Username and password matches");
        }
        else {
            System.out.println("Username and password does not match.");
        }
        return "/users/viewAllUsers";
    }


    // Update functionality for users.
    @GetMapping("/update-user/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        User userToUpdate = userRepo.getReferenceById(id);
//        String hashedPassword = userToUpdate.getPassword();
//        String password = B
        model.addAttribute("user", userToUpdate);
        return "/users/updateUser";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User updatedUser) {
        String password = updatedUser.getPassword();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        updatedUser.setPassword(hashedPassword);
        userRepo.save(updatedUser);
        return "redirect:/";
    }

    // Delete functionality for users.
    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        User userToDelete = userRepo.getReferenceById(id);
        model.addAttribute("userID", userToDelete.getId());
        userRepo.delete(userToDelete);
        return "redirect:/show-all-users";
    }
}
