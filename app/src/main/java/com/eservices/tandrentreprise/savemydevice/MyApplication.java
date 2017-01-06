package com.eservices.tandrentreprise.savemydevice;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {

    public List<Demande> contacts;

    boolean isConnect;

    @Override
    public void onCreate() {
        super.onCreate();

        contacts = new ArrayList<>();

        isConnect = false;

        contacts.add(new Demande("Dinorah", "Depaul",       "000-555-0001", "d.depaul@gmail.com"));
        contacts.add(new Demande("Adelaide","Schlueter",    "000-555-0002", "a.schlueter@gmail.com"));
        contacts.add(new Demande("Brian",   "Carruthers",   "000-555-0003", "b.carruthers@gmail.com"));
        contacts.add(new Demande("Glenna",  "Brashler",     "000-555-0004", "g.brashler@gmail.com"));
        contacts.add(new Demande("Anibal",  "Dammann",      "000-555-0005", "a.dammann@gmail.com"));
        contacts.add(new Demande("Sunday",  "Harpole",      "000-555-0006", "s.harpole@gmail.com"));
        contacts.add(new Demande("Candis",  "Tiernan",      "000-555-0007", "c.tiernan@gmail.com"));
        contacts.add(new Demande("Dori",    "Bockelman",    "000-555-0008", "d.bockelman@gmail.com"));
        contacts.add(new Demande("Odis",    "Skipper",      "000-555-0009", "o.skipper@gmail.com"));
        contacts.add(new Demande("Miquel",  "Bynoe",        "000-555-0010", "m.bynoe@gmail.com"));
        contacts.add(new Demande("Raye",    "Heffner",      "000-555-0011", "r.heffner@gmail.com"));
        contacts.add(new Demande("Pilar",   "Ramirez",      "000-555-0012", "p.ramirez@gmail.com"));
        contacts.add(new Demande("Marcia",  "Rodden",       "000-555-0013", "m.rodden@gmail.com"));
        contacts.add(new Demande("Queen",   "Lucus",        "000-555-0014", "q.lucus@gmail.com"));
        contacts.add(new Demande("Shakia",  "Dalke",        "000-555-0015", "s.dalke@gmail.com"));
    }
}
