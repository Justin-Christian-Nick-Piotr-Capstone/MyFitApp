package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyLogRepo extends JpaRepository<DailyLog, Long> {
}
