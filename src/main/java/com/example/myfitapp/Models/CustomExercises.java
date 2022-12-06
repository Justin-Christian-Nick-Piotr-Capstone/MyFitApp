package com.example.myfitapp.Models;


import jakarta.persistence.*;

@Table(name="custom_exercises")
@Entity
public class CustomExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long calories;
    @Column
    private String query;

    public CustomExercises() {

    }
//    public CustomExercises(long id, long calories, String query, User user) {
//        this.id = id;
//        this.query = query;
//        this.user = user;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCalories() {
        return calories;
    }

    public void setCalories(long calories) {
        this.calories = calories;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
