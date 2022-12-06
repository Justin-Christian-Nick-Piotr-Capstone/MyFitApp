package com.example.myfitapp.Repos;

import com.example.myfitapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This repo gives all the methods that will be needed to manipulate the database data.
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
