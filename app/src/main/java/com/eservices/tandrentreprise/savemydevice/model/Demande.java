package com.eservices.tandrentreprise.savemydevice.model;

import java.io.Serializable;

/**
 * Modele d'une demande d'aide
 *  */

public class Demande implements Serializable {

    public String title;
    public String detail;
    public String type;
    public Integer idUser;

    public Demande(String title, String detail, String type, Integer idUser) {
        this.title = title;
        this.detail = detail;
        this.type = type;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return title + " " + detail;
    }
}
