package com.eservices.tandrentreprise.savemydevice;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.Candidature;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {

    private FirebaseAuth auth;


    public final List<Demande> demands = new ArrayList<Demande>();
    public List<Demande> myDemands;
    public List<Candidature> postulants;

    public Demande demandeActuelle = null;

    public User connectedUser;

    @Override
    public void onCreate() {
        super.onCreate();

        myDemands = new ArrayList<>();
        postulants = new ArrayList<>();


        /**Liste des demandes*/
 /*       demands.add(new Demande("Problème ordinateur", Area.HDF, "Orinateur ne démarre plus", "Hardware","Ordinateur Dell XY", "3EDEDE"));
        demands.add(new Demande("Problème PC", Area.BFC,"Il ne démarre plus", "Hardware", "Asus rogue one","3ED"));
        demands.add(new Demande("Problème fichier word", Area.HDF,  "Il s'ouvre pas",  "Software", "MacBook Pro", "ZSs2"));
        demands.add(new Demande("Problème internet", Area.OCC, "Impossible d'acceder à internet", "Software","MacBook air 2", "SDD3"));
        demands.add(new Demande("Problème tablette", Area.PDL,  "Elle s'éteinds toute seule",  "Hardware", "Ipad 2","DD323"));
        demands.add(new Demande("Lenteur internet", Area.GE,  "Navigateur plein de pub",  "Software", "Lenovo yoga", "DDE233"));


        *//**Mes demandes*//*
        myDemands.add(demands.get(0));*/


        /**Postulants a mes demandes*/
        postulants.add(new Candidature(1,"Roger", 15, true));
        postulants.add(new Candidature(2,"Tibtib", 17, true));
        postulants.add(new Candidature(3,"Jacquie", 12, false));
    }


    public void getConnectedUser(){
        auth = FirebaseAuth.getInstance();

        connectedUser = new User("", "" ,"Tibooh", "Pernet", "Thibaut", Area.HDF, 23, "28 rue de Lille", "59000" ,"LILLE", 5, 8, 385);

    }

    public void getAllDemandes() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference demandesRef = database.getReference("demandes");

        demands.clear();
        ChildEventListener demandeListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Demande demande= dataSnapshot.getValue(Demande.class);
                demands.add(demande);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Demande demande= dataSnapshot.getValue(Demande.class);
                demands.add(demande);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Demande demande= dataSnapshot.getValue(Demande.class);
                demands.add(demande);
            }



            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Demande demande= dataSnapshot.getValue(Demande.class);
                    demands.add(demande);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("getAllDemandes", "loadPost:onCancelled", databaseError.toException());
            }
        };
        demandesRef.addChildEventListener(demandeListener);
    }
}




