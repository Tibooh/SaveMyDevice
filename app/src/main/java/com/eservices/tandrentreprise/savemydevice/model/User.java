package com.eservices.tandrentreprise.savemydevice.model;

/**
 *  Modele de donnée User
 * Created by tibo000 on 03/03/2017.
 */
public class User {

    public String uIdUser;
    public String providerIdUser;

    public String pseudo;
    public String nom;
    public String prenom;
    public String region;
    public int age;
    public String adresse;
    public String codePostal;
    public String ville;
    public int nbIntervention;
    public int nbAnnonces;
    public int gainTotal;


    public User(){
    }

    public User(String uIdUser, String providerIdUser, String pseudo, String nom, String prenom, String region, int age, String adresse, String codePostal, String ville, int nbIntervention, int nbAnnonces, int gainTotal) {
        this.uIdUser = uIdUser;
        this.providerIdUser = providerIdUser;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.region = region;
        this.age = age;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.nbIntervention = nbIntervention;
        this.nbAnnonces = nbAnnonces;
        this.gainTotal = gainTotal;
    }

    public String getuIdUser() {
        return uIdUser;
    }

    public void setuIdUser(String uIdUser) {
        this.uIdUser = uIdUser;
    }

    public String getProviderIdUser() {
        return providerIdUser;
    }

    public void setProviderIdUser(String providerIdUser) {
        this.providerIdUser = providerIdUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNbIntervention() {
        return nbIntervention;
    }

    public void setNbIntervention(int nbIntervention) {
        this.nbIntervention = nbIntervention;
    }

    public int getNbAnnonces() {
        return nbAnnonces;
    }

    public void setNbAnnonces(int nbAnnonces) {
        this.nbAnnonces = nbAnnonces;
    }

    public int getGainTotal() {
        return gainTotal;
    }

    public void setGainTotal(int gainTotal) {
        this.gainTotal = gainTotal;
    }
}