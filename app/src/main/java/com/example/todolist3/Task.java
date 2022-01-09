package com.example.todolist3;

import java.util.Date;

public class Task {

    private String nom;
    private String description;
    private String date;
    private String heure_debut;
    private String heure_fin;

    public Task(String nom, String description, String date, String heure_debut, String heure_fin){
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
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

    public String getHeureFin() {
        return heure_fin;
    }
}
