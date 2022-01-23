package com.example.todolist3;

import java.util.Date;

public class Task {

    private String nom;
    private String description;
    private String date;
    private String heure_debut;

    public Task(String nom, String description, String date, String heure_debut){
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.heure_debut = heure_debut;
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

    public String getHeureDebut() {
        return heure_debut;
    }

    @Override
    public String toString() {
        return "Task{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", heure_debut='" + heure_debut + '\'' +
                '}';
    }
}
