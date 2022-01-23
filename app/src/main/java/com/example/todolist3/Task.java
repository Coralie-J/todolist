package com.example.todolist3;

import java.util.Date;

public class Task {

    private String nom;
    private String date;
    private String heure_debut;

    public Task(String nom, String date, String heure_debut){
        this.nom = nom;
        this.date = date;
        this.heure_debut = heure_debut;
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
                ", date='" + date + '\'' +
                ", heure_debut='" + heure_debut + '\'' +
                '}';
    }
}
