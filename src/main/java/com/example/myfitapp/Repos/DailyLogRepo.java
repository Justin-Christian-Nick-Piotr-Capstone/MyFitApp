package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.DailyLog;
import com.example.myfitapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyLogRepo extends JpaRepository<DailyLog, Long> {
    List<DailyLog> findDailyLogByUser(User user);
}
