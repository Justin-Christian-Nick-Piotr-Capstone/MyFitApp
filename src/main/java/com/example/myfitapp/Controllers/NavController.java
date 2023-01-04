package com.example.myfitapp.Controllers;

import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/about-us.html")
    public String showAboutUs(){
        return"/about-us";
    }

    @GetMapping("/profile.html")
    public String showProfile(){
        return "/profile";
    }

    @GetMapping("/homepage.html")
    public String showHomepage(){
        return"/homepage";
    }



}
