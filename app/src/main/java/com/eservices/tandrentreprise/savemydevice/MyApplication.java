package com.eservices.tandrentreprise.savemydevice;

import android.app.Application;

import com.eservices.tandrentreprise.savemydevice.model.Demande;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {

    public List<Demande> demands;
    public List<Demande> myDemands;


    boolean isConnect;

    @Override
    public void onCreate() {
        super.onCreate();

        demands = new ArrayList<>();

        isConnect = false;

        demands.add(new Demande("Problème ordinateur", "Orinateur ne démarre plus",       "000-555-0001", 1));
        demands.add(new Demande("Problème PC","Il ne démarre plus",    "000-555-0002", 2));
        demands.add(new Demande("Problème tablette",   "Elle s'éteinds toute seule",   "000-555-0003", 3));
        demands.add(new Demande("Problème fichier word",  "Il s'ouvre pas",     "000-555-0004", 4));
        demands.add(new Demande("Problème internet",  "Impossible d'acceder à internet",      "000-555-0005", 5));
        demands.add(new Demande("Lenteur internet",  "Navigateur plein de pub",      "000-555-0006",6));


/*        myDemands.add(demands.get(1));
        myDemands.add(demands.get(2));
        myDemands.add(demands.get(3));*/


    }
}
