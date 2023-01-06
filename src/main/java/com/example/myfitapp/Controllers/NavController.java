package com.example.myfitapp.Controllers;

import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/profile";
    }

    @GetMapping("/about-us")
    public String showAboutUsPage() {
        return "/about-us";
    }

    @GetMapping("/homepage")
    public String showHomePage() {
        return "/homepage";
    }
}
