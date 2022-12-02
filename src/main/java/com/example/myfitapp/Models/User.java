package com.example.myfitapp.Models;

import jakarta.persistence.*;

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
    private int targetWeight;
    @Column
    private String profile_visibility;
    @Column
    private int progress;

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
    public int getTargetWeight() {
        return targetWeight;
    }
    public void setTargetWeight(int targetWeight) {
        this.targetWeight = targetWeight;
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