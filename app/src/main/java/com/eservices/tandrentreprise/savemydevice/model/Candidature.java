package com.eservices.tandrentreprise.savemydevice.model;

/**
 * Modele de donnée candidature
 * Created by tibo000 on 27/01/2017.
 */
public class Candidature {
    public Integer idCandidature;
    public String nomPostulant;
    public Integer prixPropose;
    public boolean peutBouger;



    public Candidature(Integer idCandidature, String nomPostulant, Integer prixPropose, boolean peutBouger) {
        this.idCandidature = idCandidature;
        this.nomPostulant=nomPostulant;
        this.prixPropose=prixPropose;
        this.peutBouger=peutBouger;
    }

    @Override
    public String toString() {
        return nomPostulant;
    }
}
