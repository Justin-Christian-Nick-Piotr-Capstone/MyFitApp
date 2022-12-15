package com.example.myfitapp.Controllers;

import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/about-us")
    public String showAboutUs(){
        return"/about-us";
    }

    @GetMapping("/profile")
    public String showProfile(){
        return "/profile";
    }

    @GetMapping("/homepage")
    public String showHomepage(){
        return"/homepage";
    }

}
