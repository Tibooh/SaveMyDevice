package com.eservices.tandrentreprise.savemydevice.model;

/**
 *  Modele de donnée User
 * Created by tibo000 on 03/03/2017.
 */
public class User {
    public String pseudo;
    public String nom;
    public String prenom;
    public String region;
    public int age;
    public String mail;

    public User(){
    }

    public User(String pseudo, String nom, String prenom, String region, int age, String mail) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.region = region;
        this.age = age;
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}