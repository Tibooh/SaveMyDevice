package com.eservices.tandrentreprise.savemydevice;

import java.io.Serializable;

/**
 * Created by stamper on 30/09/16.
 */

public class Contact implements Serializable {

    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String emailAddress;

    public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
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
