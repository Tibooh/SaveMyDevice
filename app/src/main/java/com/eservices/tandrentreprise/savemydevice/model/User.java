package com.eservices.tandrentreprise.savemydevice.model;

/**
 *  Modele de donnée User
 * Created by tibo000 on 03/03/2017.
 */
public class User {

    public String uIdUser;
    public String providerIdUser;

    public String pseudo;
    public String nomPrenom;
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

    public User(String uIdUser, String pseudo, String nomPrenom, String region, int age, String adresse, String codePostal, String ville) {
        this.uIdUser = uIdUser;
        this.pseudo = pseudo;
        this.nomPrenom = nomPrenom;
        this.age = age;
        this.region = region;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.nbIntervention = 0;
        this.nbAnnonces = 0;
        this.gainTotal = 0;
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

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
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