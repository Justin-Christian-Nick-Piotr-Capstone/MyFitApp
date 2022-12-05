package com.example.myfitapp.Models;


import jakarta.persistence.*;

@Entity
@Table(name="exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String exercise_name;

    //field for exercise duration, in minutes

    private long exercise_duration;

    //based on exercise type from the name, should be able to calculate duraction and this calories/hour
    @Column
    private long calories_per_hour;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public long getExercise_duration() {
        return exercise_duration;
    }

    public void setExercise_duration(long exercise_duration) {
        this.exercise_duration = exercise_duration;
    }

    public long getCalories_per_hour() {
        return calories_per_hour;
    }

    public void setCalories_per_hour(long calories_per_hour) {
        this.calories_per_hour = calories_per_hour;
    }
}
