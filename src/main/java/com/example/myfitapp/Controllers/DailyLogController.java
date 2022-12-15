package com.example.myfitapp.Controllers;


import com.example.myfitapp.Models.CustomExercise;
import com.example.myfitapp.Models.DailyLog;
import com.example.myfitapp.Models.User;
import com.example.myfitapp.Repos.CustomExerciseRepo;
import com.example.myfitapp.Repos.DailyLogRepo;
import com.example.myfitapp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DailyLogController {

    @Autowired
    DailyLogRepo dailyLogRepo;

    @Autowired
    CustomExerciseRepo customExerciseRepo;

    @Autowired
    UserRepo userRepo;

    // Get all the daily logs in the database
    @GetMapping("/view-all-daily-logs")
    public String viewAllDailyLogs(Model model) {
        User userLoggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<DailyLog> dailyLogs = dailyLogRepo.findAll();
        for (int i = 0; i < dailyLogs.size(); i++) {
            DailyLog dailyLog = dailyLogs.get(i);
            if (dailyLog.getUser().getId() != userLoggedIn.getId()) {
                dailyLogs.remove(i);
                i-=1;
//                System.out.println("Custom exercise " + customExercise.getId() + " removed.");
            }
//            System.out.println("----------------------------------------------------");
        }
        model.addAttribute("daily_logs", dailyLogs);
        model.addAttribute("user", userLoggedIn);
        return "/dailyLogs/viewAllDailyLogs";
    }

    // Get all the daily logs for a specific user
//    @GetMapping("/view-all-daily-logs/userID/{id}")
//    public String viewSpecificUserDailyLogs(@PathVariable long id, Model model) {
//        User user = userRepo.getReferenceById(id);
//        List<DailyLog> dailyLogs = user.getDailyLogs();
//        model.addAttribute("daily_logs", dailyLogs);
//        return "/dailyLogs/viewAllDailyLogs";
//    }

    @GetMapping("/view-daily-log")
    public String viewDailyLog(Model model) {
        User userLoggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Getting the date for the daily log and checking to see if a daily log with that date already exists.
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        List<DailyLog> dailyLogs = dailyLogRepo.findDailyLogByUser(userLoggedIn);
        boolean logForDateExists = false;
        // This loops through the daily log list and if there is already a log for that date,
        // it sets the model attribute and breaks.
        // Otherwise, it will create a new daily log and pass that in as the model.
        for (int i = 0; i < dailyLogs.size(); i++) {
            if (dailyLogs.get(i).getDate().equals(date)) {
                model.addAttribute("dailyLog", dailyLogs.get(i));
                System.out.println(dailyLogs.get(i).getDate());
                logForDateExists = true;
                break;
            }
        }
        if (!logForDateExists) {
            DailyLog dailyLog;
            // Checks if the user wants to gain or lose weight and sets the calorie value accordingly.
            if (userLoggedIn.getTarget_weight() < userLoggedIn.getStarting_weight()) {
                dailyLog = new DailyLog(date, (userLoggedIn.getMaintenance_calories() - 500), 0, userLoggedIn);
            } else {
                dailyLog = new DailyLog(date, (userLoggedIn.getMaintenance_calories() + 500), 0, userLoggedIn);
            }
            model.addAttribute("dailyLog", dailyLog);
            System.out.println(dailyLog.getDate());
            dailyLogRepo.save(dailyLog);
        }
        List<CustomExercise> customExerciseList = customExerciseRepo.findCustomExerciseByUser(userLoggedIn);
        model.addAttribute("customExercises", customExerciseList);
        System.out.println("IT works until here");
        System.out.println("THE DAY IS: " + date);
        return "dailyLogs/viewDailyLog";
    }



    // Show daily log form
    @GetMapping("/create-daily-log")
    public String createDailyLog(Model model) {
        DailyLog dailyLog = new DailyLog();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
