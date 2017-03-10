package com.eservices.tandrentreprise.savemydevice;

import android.accounts.Account;
import android.app.Application;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eservices.tandrentreprise.savemydevice.activities.MainActivity;
import com.eservices.tandrentreprise.savemydevice.fragments.ListDemandFragment;
import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.Candidature;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {

    public FirebaseAuth auth;


    public final List<Demande> demands = new ArrayList<Demande>();
    public final List<Demande> myDemands = new ArrayList<Demande>();
    public final List<User> users= new ArrayList<User>();


    public Demande demandeActuelle = null;

    public User connectedUser = new User();

    @Override
    public void onCreate() {
        super.onCreate();


        /**Liste des demandes*/
 /*       demands.add(new Demande("Problème ordinateur", Area.HDF, "Orinateur ne démarre plus", "Hardware","Ordinateur Dell XY", "3EDEDE"));
        demands.add(new Demande("Problème PC", Area.BFC,"Il ne démarre plus", "Hardware", "Asus rogue one","3ED"));
        demands.add(new Demande("Problème fichier word", Area.HDF,  "Il s'ouvre pas",  "Software", "MacBook Pro", "ZSs2"));
        demands.add(new Demande("Problème internet", Area.OCC, "Impossible d'acceder à internet", "Software","MacBook air 2", "SDD3"));
        demands.add(new Demande("Problème tablette", Area.PDL,  "Elle s'éteinds toute seule",  "Hardware", "Ipad 2","DD323"));
        demands.add(new Demande("Lenteur internet", Area.GE,  "Navigateur plein de pub",  "Software", "Lenovo yoga", "DDE233"));


        *//**Mes demandes*/


        /**Postulants a mes demandes*/
/*        postulants.add(new Candidature(1,"Roger", 15, true));
        postulants.add(new Candidature(2,"Tibtib", 17, true));
        postulants.add(new Candidature(3,"Jacquie", 12, false));*/
    }


    public void getAllDemandes() {


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference demandesRef = database.getReference("demandes");

        demands.clear();

        ChildEventListener demandeListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Demande demande = dataSnapshot.getValue(Demande.class);
                demands.add(demande);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Demande demande = dataSnapshot.getValue(Demande.class);
                demands.add(demande);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Demande demande = dataSnapshot.getValue(Demande.class);
                demands.add(demande);
            }


            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Demande demande = dataSnapshot.getValue(Demande.class);
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

    public void getAllUsers()
    {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersRef = database.child("users");
        ChildEventListener usersListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                users.add(user);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                users.add(user);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                users.add(user);
            }


            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    User user = data.getValue(User.class);
                    users.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("getAllDemandes", "loadPost:onCancelled", databaseError.toException());
            }
        };
        usersRef.addChildEventListener(usersListener);

    }


    public void getConnectedUser(FirebaseUser currentUser) {

        for (User user : users)
        {
            if (user.getuIdUser().equals(currentUser.getUid()))
            {
                connectedUser = user;
            }
        }
//        connectedUser.setPseudo(currentUser.getDisplayName());
//        connectedUser.setAdresse("25 rue des champs");
//        connectedUser.setAge(23);
//        connectedUser.setCodePostal("59998");
//        connectedUser.setNomPrenom("Thibaut pernet");
//        connectedUser.setRegion(Area.HDF);
//        connectedUser.setVille("LILLE");
//        connectedUser.setNbAnnonces(20);
//        connectedUser.setNbIntervention(18);
//        connectedUser.setGainTotal(550);
    }

    public void getMyDemands() {
        myDemands.clear();
        for (Demande d : demands) {
            if (d.getIdUser().equals(connectedUser.getuIdUser())) {
                myDemands.add(d);
            }
        }
    }



}




