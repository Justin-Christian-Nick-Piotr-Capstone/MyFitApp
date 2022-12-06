package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.DailyLog;
import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.DailyLogRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DailyLogController {

    @Autowired
    DailyLogRepo dailyLogRepo;

    @Autowired
    UserRepo userRepo;

    // Get all the daily logs in the database
    @GetMapping("/view-all-daily-logs")
    public String viewAllDailyLogs(Model model) {
        model.addAttribute("daily_logs", dailyLogRepo.findAll());
        return "/dailyLogs/allDailyLogs";
    }

    // Get all the daily logs for a specific user
    @GetMapping("/view-all-daily-logs/userID/{id}")
    public String viewSpecificUserDailyLogs(@PathVariable long id, Model model) {
        User user = userRepo.getReferenceById(id);
        List<DailyLog> dailyLogs = user.getDailyLogs();
        model.addAttribute("daily_logs", dailyLogs);
        return "/dailyLogs/allDailyLogs";
    }


    // Show daily log form
    @GetMapping("/create-daily-log")
    public String createDailyLog(Model model) {
        DailyLog dailyLog = new DailyLog();
        User user = userRepo.getReferenceById(1L);
        dailyLog.setUser(user);
        model.addAttribute("daily_log", dailyLog);
        return "/dailyLogs/createDailyLog";
    }

    // Handles the post request for the daily log
    @PostMapping("/create-daily-log")
    public String createDailyLog(@ModelAttribute DailyLog dailyLog) {
        User user = dailyLog.getUser();
        dailyLog.setUser(user);
        dailyLogRepo.save(dailyLog);
        return "redirect:/view-all-daily-logs";
    }

    // Update daily log
    @GetMapping("/update-daily-log/{id}")
    public String showUpdateDailyLog(@PathVariable long id, Model model) {
        DailyLog logToUpdate = dailyLogRepo.getReferenceById(id);
        model.addAttribute("daily_log", logToUpdate);
        return "/dailyLogs/updateDailyLog";
    }

    @PostMapping("/update-daily-log")
    public String updateDailyLog(@ModelAttribute DailyLog dailyLog) {
        dailyLogRepo.save(dailyLog);
        return "redirect:/view-all-daily-logs";
    }

    @PostMapping("/delete-daily-log/{id}")
    public String deleteDailyLog(@PathVariable long id) {
        DailyLog logToDelete = dailyLogRepo.getReferenceById(id);
        dailyLogRepo.delete(logToDelete);
        return "redirect:/view-all-daily-logs";
    }

}
