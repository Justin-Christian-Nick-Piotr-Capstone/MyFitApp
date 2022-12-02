package com.example.myfitapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//Need to switch which one of these is commented out in order to have user authentication. This makes it easier to test though.
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@SpringBootApplication
public class MyFitAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFitAppApplication.class, args);
    }

}
