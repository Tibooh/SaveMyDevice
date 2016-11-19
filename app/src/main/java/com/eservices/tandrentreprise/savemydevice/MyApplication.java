package com.eservices.tandrentreprise.savemydevice;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {

    public List<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();

        contacts = new ArrayList<>();

        contacts.add(new Contact("Dinorah", "Depaul",       "000-555-0001", "d.depaul@gmail.com"));
        contacts.add(new Contact("Adelaide","Schlueter",    "000-555-0002", "a.schlueter@gmail.com"));
        contacts.add(new Contact("Brian",   "Carruthers",   "000-555-0003", "b.carruthers@gmail.com"));
        contacts.add(new Contact("Glenna",  "Brashler",     "000-555-0004", "g.brashler@gmail.com"));
        contacts.add(new Contact("Anibal",  "Dammann",      "000-555-0005", "a.dammann@gmail.com"));
        contacts.add(new Contact("Sunday",  "Harpole",      "000-555-0006", "s.harpole@gmail.com"));
        contacts.add(new Contact("Candis",  "Tiernan",      "000-555-0007", "c.tiernan@gmail.com"));
        contacts.add(new Contact("Dori",    "Bockelman",    "000-555-0008", "d.bockelman@gmail.com"));
        contacts.add(new Contact("Odis",    "Skipper",      "000-555-0009", "o.skipper@gmail.com"));
        contacts.add(new Contact("Miquel",  "Bynoe",        "000-555-0010", "m.bynoe@gmail.com"));
        contacts.add(new Contact("Raye",    "Heffner",      "000-555-0011", "r.heffner@gmail.com"));
        contacts.add(new Contact("Pilar",   "Ramirez",      "000-555-0012", "p.ramirez@gmail.com"));
        contacts.add(new Contact("Marcia",  "Rodden",       "000-555-0013", "m.rodden@gmail.com"));
        contacts.add(new Contact("Queen",   "Lucus",        "000-555-0014", "q.lucus@gmail.com"));
        contacts.add(new Contact("Shakia",  "Dalke",        "000-555-0015", "s.dalke@gmail.com"));
    }
}
