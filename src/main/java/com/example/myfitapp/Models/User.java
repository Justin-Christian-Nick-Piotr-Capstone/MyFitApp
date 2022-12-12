package com.example.myfitapp.Models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    // Setting all the columns for the data that will be entered in the table.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private int height;
    @Column
    private int age;
    @Column
    private String gender;
    @Column
    private int maintenance_calories;
    @Column
    private int starting_weight;
    @Column
    private int target_weight;
    @Column
    private String profile_visibility;
    @Column
    private int progress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<DailyLog> dailyLogs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CustomExercise> customExercises;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CustomMeal> customMeals;

    public User() {}
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        height = copy.height;
        age = copy.height;
        gender = copy.gender;
        maintenance_calories = copy.maintenance_calories;
        starting_weight = copy.starting_weight;
        target_weight = copy.target_weight;
        profile_visibility = copy.profile_visibility;
        progress = copy.progress;
    }

    public List<DailyLog> getDailyLogs() {
        return dailyLogs;
    }

    public void setDailyLogs(List<DailyLog> dailyLogs) {
        this.dailyLogs = dailyLogs;
    }

    // Everything from here down are the getters and setters for the properties above.
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getMaintenance_calories() {
        return maintenance_calories;
    }
    public void setMaintenance_calories(int maintenance_calories) {
        this.maintenance_calories = maintenance_calories;
    }
    public int getStarting_weight() {
        return starting_weight;
    }
    public void setStarting_weight(int starting_weight) {
        this.starting_weight = starting_weight;
    }
    public int getTarget_weight() {
        return target_weight;
    }
    public void setTarget_weight(int targetWeight) {
        this.target_weight = targetWeight;
    }
    public String getProfile_visibility() {
        return profile_visibility;
    }
    public void setProfile_visibility(String profile_visibility) {
        this.profile_visibility = profile_visibility;
    }
    public int getProgress() {
        return progress;
    }
    public void setProgress(int progress) {
        this.progress = progress;
    }
}