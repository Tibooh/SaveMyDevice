package com.eservices.tandrentreprise.savemydevice.models;

import java.io.Serializable;

/**
 * Modele d'une demande d'aide
 *  */

public class Demande implements Serializable {

    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String emailAddress;

    public Demande(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
