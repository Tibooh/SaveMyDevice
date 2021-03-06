package com.eservices.tandrentreprise.savemydevice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Modele d'une demande d'aide
 *  */

public class Demande implements Serializable {


    public String idDemande;
    public String title;
    public String area;
    public String detail;
    public String type;
    public String modeleAppareil;
    public String idUser;
    public Integer idDepanneur;
    public List<Candidature> candidatures = new ArrayList<Candidature>();

    public Candidature candidatureFinale;

    public Candidature getCandidatureFinale() {
        return candidatureFinale;
    }

    public void setCandidatureFinale(Candidature candidatureFinale) {
        this.candidatureFinale = candidatureFinale;
    }


    public Date dateDemande;


    public Demande(){}

    public Demande(String title, String area, String detail, String type, String modeleAppareil ,String idUser, Date dateDemande) {
        this.title = title;
        this.area = area;
        this.detail = detail;
        this.type = type;
        this.modeleAppareil = modeleAppareil;
        this.idUser = idUser;
        this.dateDemande=dateDemande;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    @Override
    public String toString() {
        return title + " " + detail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setIdDemande(String idDemande) {
        this.idDemande = idDemande;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModeleAppareil(String modeleAppareil) {
        this.modeleAppareil = modeleAppareil;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdDepanneur(Integer idDepanneur) {
        this.idDepanneur = idDepanneur;
    }

    public String getIdDemande() {
        return idDemande;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
    }

    public String getDetail() {
        return detail;
    }

    public String getType() {
        return type;
    }

    public String getModeleAppareil() {
        return modeleAppareil;
    }

    public String getIdUser() {
        return idUser;
    }

    public Integer getIdDepanneur() {
        return idDepanneur;
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }
}
