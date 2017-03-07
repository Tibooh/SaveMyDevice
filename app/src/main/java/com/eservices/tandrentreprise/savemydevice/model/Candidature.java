package com.eservices.tandrentreprise.savemydevice.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Modele de donnée candidature
 * Created by tibo000 on 27/01/2017.
 */

public class Candidature {
    public int getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }

    public String getNomPostulant() {
        return nomPostulant;
    }

    public void setNomPostulant(String nomPostulant) {
        this.nomPostulant = nomPostulant;
    }

    public Integer getPrixPropose() {
        return prixPropose;
    }

    public void setPrixPropose(Integer prixPropose) {
        this.prixPropose = prixPropose;
    }

    public boolean isPeutBouger() {
        return peutBouger;
    }

    public void setPeutBouger(boolean peutBouger) {
        this.peutBouger = peutBouger;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateMAJ() {
        return dateMAJ;
    }

    public void setDateMAJ(String dateMAJ) {
        this.dateMAJ = dateMAJ;
    }

    public int idCandidature;
    public String nomPostulant;
    public Integer prixPropose;
    public boolean peutBouger;
    public Date dateCreation;
    public String dateMAJ;


    public Candidature(){}

    public Candidature(int idCandidature,String nomPostulant, Integer prixPropose, boolean peutBouger) {
        this.idCandidature = idCandidature;
        this.nomPostulant=nomPostulant;
        this.prixPropose=prixPropose;
        this.peutBouger=peutBouger;
        this.dateCreation=Calendar.getInstance().getTime();

    }

    @Override
    public String toString() {
        return nomPostulant;
    }
}
