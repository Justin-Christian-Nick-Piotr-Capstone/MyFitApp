package com.example.myfitapp.Models;


import javax.persistence.*;

@Entity
@Table(name = "daily_log")
public class DailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String date;
    @Column
    private String exercise_query;
    @Column
    private String meals_query;
    @Column
    private int target_calories;
    @Column
    private int current_calories;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExercise_query() {
        return exercise_query;
    }

    public void setExercise_query(String exercise_query) {
        this.exercise_query = exercise_query;
    }

    public String getMeals_query() {
        return meals_query;
    }

    public void setMeals_query(String meals_query) {
        this.meals_query = meals_query;
    }

    public int getTarget_calories() {
        return target_calories;
    }

    public void setTarget_calories(int target_calories) {
        this.target_calories = target_calories;
    }

    public int getCurrent_calories() {
        return current_calories;
    }

    public void setCurrent_calories(int current_calories) {
        this.current_calories = current_calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
