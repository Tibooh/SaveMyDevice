package com.eservices.tandrentreprise.savemydevice.model;

import java.io.Serializable;

/**
 * Modele d'une demande d'aide
 *  */

public class Demande implements Serializable {


    public Integer idDemande;
    public String title;
    public String area;
    public String detail;
    public String type;
    public String modeleAppareil;
    public String idUser;
    public Integer idDepanneur;

    public Demande(String title, String area, String detail, String type, String modeleAppareil ,String idUser) {
        this.title = title;
        this.area = area;
        this.detail = detail;
        this.type = type;
        this.modeleAppareil = modeleAppareil;
        this.idUser = idUser;
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

    public void setIdDemande(Integer idDemande) {
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
    public Integer getIdDemande() {
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
}
