package com.eservices.tandrentreprise.savemydevice.model;

import java.io.Serializable;

/**
 * Modele d'une demande d'aide
 *  */

public class Demande implements Serializable {

    public Integer idDemande;
    public String title;
    public String detail;
    public String type;
    public String modeleAppareil;
    public Integer idUser;
    public Integer idDepanneur;

    public Demande(Integer idDemande, String title, String detail, String type, String modeleAppareil ,Integer idUser, Integer idDepanneur) {
        this.idDemande = idDemande;
        this.title = title;
        this.detail = detail;
        this.type = type;
        this.modeleAppareil = modeleAppareil;
        this.idUser = idUser;
        this.idDepanneur = idDepanneur;
    }

    @Override
    public String toString() {
        return title + " " + detail;
    }
}
