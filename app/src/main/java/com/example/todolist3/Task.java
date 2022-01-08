package com.example.todolist3;

import java.util.Date;

public class Task {

    private String nom;
    private String description;
    private String date;

    public Task(String nom, String description, String date){
        this.nom = nom;
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }
}
